package controllers.tasks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createTask")
public class CreateTaskContoller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("progress", 70);
        RequestDispatcher dispatcher = req.getRequestDispatcher("create-task.jsp");
        dispatcher.forward(req, resp);
    }
}
