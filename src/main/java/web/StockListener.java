package web;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * Servlet implementation class StockService
 */
@Path("stock")
public class StockListener {

	public StockListener() {

	}

	@GET
	@Produces("text/html")	
	public String getStockResponse() throws IOException {
		System.err.println("inside get request");
		String response = "<h1>WELCOME VISITOR</h1>"
				+ "<p>You've reached the StockService response page</p>"
				+ "<img height=\"30%\" width=\"40%\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Texas_Longhorn_logo.svg/2000px-Texas_Longhorn_logo.svg.png\">";

		// Set response content type
		/*Set<Entry<String, String[]>> parameters = request.getParameterMap().entrySet();
		for(Entry<String, String[]> param : parameters) {
			String key = param.getKey();
			String[] value = param.getValue();
			String paramString = key + ":\t" + Arrays.toString(value);
			System.out.println(paramString);
			out.println("<p>" + paramString + "</p>");
		}*/
		
		return response;

	}

	//@POST 
	//@Produces("text/html")
	public void postStockResponse() throws IOException {
		System.err.println("Servicing post request.");
		// Actual logic goes here.
		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();

		// Set response content type
		//Set<Entry<String, String[]>> parameters = request.getParameterMap().entrySet();
		/*for(Entry<String, String[]> param : parameters) {
			String key = param.getKey();
			String[] value = param.getValue();
			String paramString = key + ":\t" + Arrays.toString(value);
			System.out.println(paramString);
			out.println("<p>" + paramString + "</p>");
		}*/
	}

}
