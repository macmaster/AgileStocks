/** StockBean.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on Jun 2, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

/**
 * Application Layer Class to handle the Stock Computations/fetching
 * @author ronny
 *
 */
public class StockBean {
	
	/**
	 * map of query flags to a query pair. left pair value is the query flag's name. right pair value is the yahoo
	 * finance query flag.
	 */
	private Map<String, Pair<String, String>> queryMap;

	/**
	 * Stock computation processor
	 */
	public StockBean() {
		// init query map
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
	
	/**
	 * get the value for a particular stock query flag
	 * @param ticker
	 * @param queryFlag
	 * @return the query result
	 */
	public String getStockValue(String ticker, String queryFlag){
		String value = null;
        try{
        	// connect to yahoo finance
        	URL yahoo = new URL("http://download.finance.yahoo.com/d/quotes.csv?s="+ticker+"&f="+queryFlag);
        	URLConnection yc = yahoo.openConnection();        	
        	BufferedReader istream = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        	// read value
        	if((value = istream.readLine()) != null){ 
        		System.out.println(ticker + "\t" + value);
        	}
        	istream.close();
        } catch(Exception e){
        	e.printStackTrace();
        }
        return value;
	}
	
	@Produces("text/html")
	public String processQueries(String ticker, List<String> querys){
		// Web Page html and header
		String response = "<h1>WELCOME VISITOR</h1>"
				+ "<p>You've reached the StockService response page for <strong>" + ticker.toUpperCase() + "</strong></p>"
				+ "<img margin-left=50 height=\"40%\" width=\"40%\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Texas_Longhorn_logo.svg/2000px-Texas_Longhorn_logo.svg.png\">";

		for(String query : querys) {
			try {
				System.out.println("query: " + query);
				String name = queryMap.get(query).left;
				String queryFlag = queryMap.get(query).right.toLowerCase();
				response += "<p>" + name + ":\t" + getStockValue(ticker, queryFlag) + "</p>";
			}
			catch(Exception e) {
				System.err.println(query + " is an invalid query");
			}
		}
		return response;
	}
}
