package servletcodes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("accName") != null) {
            String name = (String) session.getAttribute("accName");
            Double balance = (Double) session.getAttribute("accBalance");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<h2>Welcome, " + name + "</h2>");
            out.println("<p>Your Account Balance is: ₹" + balance + "</p>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            response.sendRedirect("bankLogin.html");
        }
    }
}
