package servletcodes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GradeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getAttribute("name");
        String marksStr = (String) request.getAttribute("marks");

        int marks = Integer.parseInt(marksStr);
        String grade;

        if (marks >= 90) grade = "A";
        else if (marks >= 75) grade = "B";
        else if (marks >= 60) grade = "C";
        else if (marks >= 40) grade = "D";
        else grade = "F";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Student Grade Result</h2>");
        out.println("<p><b>Name:</b> " + name + "</p>");
        out.println("<p><b>Marks:</b> " + marks + "</p>");
        out.println("<p><b>Grade:</b> " + grade + "</p>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("GradeServlet is active.");
    }
}
