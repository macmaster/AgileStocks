package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import app.Pair;
import app.StockBean;

/**
 * Servlet implementation class StockService
 */
@Path("stock/{ticker}")
public class StockListener {
	/**
	 * map of query flags to a query pair.
	 * left pair value is the query flag's name. 
	 * right pair value is the yahoo finance query flag.
	 */
	private Map<String, Pair<String, String>> queryMap;
	
	/**
	 * Stock bean to handle application layer processing
	 */
	private StockBean bean = new StockBean();
	
	public StockListener() {
		// init value map
		queryMap = new HashMap<String, Pair<String, String>>();
		queryMap.put("p", new Pair<String, String>("price", "l1"));
		queryMap.put("mc", new Pair<String, String>("market cap", "j1"));
		queryMap.put("info", new Pair<String, String>("info", "i"));
		queryMap.put("eps", new Pair<String, String>("earnings per share", "e"));
		queryMap.put("ebitda", new Pair<String, String>("EBITDA", "j4"));
		queryMap.put("name", new Pair<String, String>("name", "n"));
		queryMap.put("pe", new Pair<String, String>("P/E ratio", "r"));
		queryMap.put("vol", new Pair<String, String>("volume", "v"));
		queryMap.put("ex", new Pair<String, String>("exchange", "x"));
		queryMap.put("ask", new Pair<String, String>("ask price", "a"));
		queryMap.put("bid", new Pair<String, String>("bid price", "b"));
		
		
	}

	@GET
	@Produces("text/html")
	public String getStockResponse(
			@PathParam("ticker") String ticker,
			@DefaultValue("p") @QueryParam("q") final String queryString) throws IOException {
		
		// Web Page html and header
		System.err.println("inside get request");
		String response = "<h1>WELCOME VISITOR</h1>"
				+ "<p>You've reached the StockService response page for <strong>" + ticker.toUpperCase() + "</strong></p>"
				+ "<img height=\"30%\" width=\"40%\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Texas_Longhorn_logo.svg/2000px-Texas_Longhorn_logo.svg.png\">";
		
		// parse the stock value
		String[] querys = queryString.split("[+, ]");
		for(String query : querys){
			System.out.println("query: " + query);
			try{
				String name = queryMap.get(query).left;
				String queryFlag = queryMap.get(query).right.toLowerCase();
				response += "<p>" + name + ":\t" + bean.getStockValue(ticker, queryFlag) +"</p>";
			} catch(Exception e){
				System.err.println(query + " is an invalid query");
			}
		}
		return response;

	}

	@POST 
	@Produces("text/html")
	public String postStockResponse(@PathParam("ticker") String ticker, @QueryParam("v") String value) throws IOException {
		System.err.println("Servicing post request.");
		return ticker + "\t" + value;
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
