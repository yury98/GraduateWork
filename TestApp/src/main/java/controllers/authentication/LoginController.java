package controllers.authentication;

import models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserInfo login;

    public LoginController() {
        this.login = new UserInfo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        Users user = login.validate(username, password);
        if (user != null && user.getPassword().equals(password)) {
            // Session
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            httpSession.setMaxInactiveInterval(60*60);
            user.setUserInfo(httpSession.getId());
            user.setLastLogin(new Timestamp(System.currentTimeMillis()));
            // Save users session in DB
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();


            response.sendRedirect("login-success.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
            dispatcher.forward(request, response);
        } else {
            throw new Exception("Login not successful..");
        }
    }
}
