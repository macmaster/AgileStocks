package stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockService
 */
@WebServlet("/Stock")
public class StockListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockListener() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initialize the servlet.");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Destroying the servlet.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		// Actual logic goes here.
	    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>WELCOME VISITOR</h1>"
				+ "<p>You've reached the StockService homepage</p>"
				+ "<img height=\"30%\" width=\"40%\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Texas_Longhorn_logo.svg/2000px-Texas_Longhorn_logo.svg.png\">");
		
		// Set response content type
		Set<Entry<String, String[]>> parameters = request.getParameterMap().entrySet();
		for(Entry<String, String[]> param : parameters){
			String key = param.getKey();
			String[] value = param.getValue();
			String paramString = key + ":\t" + Arrays.toString(value);
			System.out.println(paramString);
			out.println("<p>" + paramString + "</p>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
