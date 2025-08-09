package servletcodes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accNo = request.getParameter("accNo");
        String password = request.getParameter("password");

     
        if ("630198".equals(accNo) && "Raja6301".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("accName", "Rajeswara rao");
            session.setAttribute("accBalance", 300000.0);

            response.sendRedirect("balance");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Invalid account number or password</h3>");
            response.getWriter().println("<a href='bankLogin.html'>Try Again</a>");
        }
    }
}
