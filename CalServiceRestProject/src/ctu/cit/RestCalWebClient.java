package ctu.cit;

import java.io.IOException;
import java.net.URI;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;


/**
 * Servlet implementation class RestCalWebClient
 */
@WebServlet("/CalWebClient")
public class RestCalWebClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final URI uri = UriBuilder.fromUri("http://localhost:8080/CalServiceRestProject/").build();
	
    ClientConfig config = new ClientConfig();
    Client client = ClientBuilder.newClient(config);

    WebTarget target = client.target( uri );

    public RestCalWebClient() { 
        super();
        
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Write the response message, in an HTML page
		try{
			out.println("<html><head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title>Restful Calculator Service </title></head>");
			out.println("<body>"); 
			out.println("<h1> Restful Calculator Service </h1>"); 
			
			out.println("<form> Nhap so a = <input type=text name=\"numA\" /> "
					+ "         Nhap so b = <input type=text name=\"numB\" /> "
					+ "         <input type=submit value=\"Goi dich vu cong\" />"
					+ "</form> "); 
			
			String a ="0" , b = "0" ;
			
			if (request.getParameter("numA") != null && request.getParameter("numB")!="") {
				a = request. getParameter("numA");
				b = request. getParameter("numB");	
			}
			
	        String plainAnswer = target.path("rest").path("calc").path("add").path(a).path(b).request().accept(MediaType.TEXT_PLAIN).get(String.class);

			out.println("<h3> " + a + " + " + b + " = " + plainAnswer +" </h3>"); 
			out.println("</body>"); 
			out.println("</html>");		
		}
		
		finally {	out.close(); }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
