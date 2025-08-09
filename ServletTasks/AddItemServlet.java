package servletcodes;


import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getParameter("item");

        Cookie itemCookie = new Cookie("cart_" + item, item);
        itemCookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(itemCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Item added to cart: " + item + "</h2>");
        out.println("<a href='items.html'>Add More Items</a><br>");
        out.println("<a href='viewCart'>View Cart</a>");
    }
}
