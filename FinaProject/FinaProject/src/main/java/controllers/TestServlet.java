package controllers;

import models.OrgUnit;
import models.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Configuration configuration = new Configuration().configure();
//        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
//        registry.applySettings(configuration.getProperties());
//        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
//
//        // builds a session factory from the service registry
//        SessionFactory sessionFactory = configuration
//                .buildSessionFactory(serviceRegistry);
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

//        Session session = new AnnotationConfiguration().configure()
//                .buildSessionFactory().openSession();
//        Transaction t = session.beginTransaction();
//        OrgUnit orgUnit = new OrgUnit();
//        orgUnit.setOrgUnitId(3);
//        orgUnit.setOrgUnitFullName("Бауманка");
//        orgUnit.setOrgUnitShartName("Даунка");
//        session.save(orgUnit);
//
//        Users user = new Users();
//        user.setUserId(4);
//        user.setLogin("yshashkin");
//        Timestamp time = new Timestamp(System.currentTimeMillis());
//        user.setLastLogin(time);
//        user.setPassword("123");
//        user.setUserInfo("{}");
//        user.setOrgUnitByOrgUnitId(orgUnit);
//        user.setChangeHistoriesByUserId(null);
//        user.setPacksByUserId(null);
//        user.setSchemesByUserId(null);
//        user.setTagsByUserId(null);
//        user.setTasksByUserId(null);
//
//        session.save(user);
//        t.commit();

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/testPage.jsp");
        dispatcher.forward(request, response);
    }
}
