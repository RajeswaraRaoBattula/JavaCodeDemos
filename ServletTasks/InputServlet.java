package servletcodes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InputServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String marks = request.getParameter("marks");

        // Set as request attributes
        request.setAttribute("name", name);
        request.setAttribute("marks", marks);

        // Forward to GradeServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("grade");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("InputServlet is active.");
    }
}
