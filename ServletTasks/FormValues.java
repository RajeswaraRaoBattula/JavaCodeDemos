package servletcodes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormValues
 */
@WebServlet("/Std_Login")
public class FormValues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormValues() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest requestobj, HttpServletResponse responseobj) throws ServletException, IOException {
		responseobj.setContentType("text/html");//MIME TYPE
		
		PrintWriter out=responseobj.getWriter();
		out.println("<body bgcolor=lightgreen>");
		
		String a=requestobj.getParameter("u1");//username textbox
		String b=requestobj.getParameter("p1");//password textbox

		String c[]=requestobj.getParameterValues("c1");//checkbox language
		for(String i:c)
		{
			out.println("<h1>Languages:: "+i);
		}
		String d=requestobj.getParameter("r1");//radio gender
		String e[]=requestobj.getParameterValues("s1");//select option qualification
		for(String i:e)
		{
		out.println("<h1>Qualification:: "+i);
		}

		out.println("<h1>Username:: "+a + " "+ "Password:: "+b + " "+ "Gender:: "+d);



		
	}

}
