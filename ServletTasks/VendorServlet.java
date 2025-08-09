package servletcodes;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/vendors")
public class VendorServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/wipro2025";
    private static final String USER = "root";
    private static final String PASSWORD = "Raja@0510";  // Update if needed

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Vendor Records</title></head><body>");
        out.println("<h2>Vendor List</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Location</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // for Connector/J 8+
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vendors");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("location") + "</td>");
                out.println("</tr>");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace(); // Logs to server
            out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
        }

        out.println("</table></body></html>");
    }
}
