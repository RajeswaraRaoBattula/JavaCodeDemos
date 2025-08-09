package servletcodes;



import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/viewCart")
public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Your Shopping Cart:</h2>");

        boolean hasItems = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("cart_")) {
                    out.println("<li>" + cookie.getValue() + "</li>");
                    hasItems = true;
                }
            }
        }

        if (!hasItems) {
            out.println("<p>Your cart is empty.</p>");
        }

        out.println("<br><a href='items.html'>Go Back</a>");
    }
}
