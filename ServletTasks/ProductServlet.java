package servletcodes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/product")

public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selected = request.getParameter("product");  // e.g., "Laptop-50000"
        String[] parts = selected.split("-");

        String name = parts[0];
        String price = parts[1];

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Enter Quantity</h2>");
        out.println("<form action='order' method='post'>");
        out.println("Quantity: <input type='number' name='quantity' required><br><br>");
        out.println("<input type='hidden' name='product' value='" + name + "'>");
        out.println("<input type='hidden' name='price' value='" + price + "'>");
        out.println("<input type='submit' value='Place Order'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("ProductServlet is working.");
    }
}
