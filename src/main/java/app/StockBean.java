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

import stock.Stock;

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
	
	@Produces("application/json")
	public Stock buildStockJSON(String ticker){
		Stock stock = new Stock(ticker);
		stock.setName(getStockValue(ticker, "n"));
		stock.setAsk(getStockValue(ticker, "a"));
		stock.setBid(getStockValue(ticker, "b"));
		stock.setPrice(getStockValue(ticker, "l1"));
		stock.setMarketCap(getStockValue(ticker, "j1"));
		stock.setEarningsPerShare(getStockValue(ticker, "e"));
		stock.setEbitda(getStockValue(ticker, "j4"));
		stock.setVolume(getStockValue(ticker, "v"));
		stock.setPe(getStockValue(ticker, "r"));
		return stock;
	}
	
	@Produces("application/json")
	public Stock processQueriesJSON(String ticker, List<String> querys){
		Stock stock = new Stock(ticker);
		for(String query : querys){
			try{
				String queryFlag = queryMap.get(query).right.toLowerCase();
				if(queryFlag.equals("n")){ // name
					stock.setName(getStockValue(ticker, "n"));
				}
				else if(queryFlag.equals("a")){ // ask
					stock.setAsk(getStockValue(ticker, "a"));
				}
				else if(queryFlag.equals("b")){ // bid
					stock.setBid(getStockValue(ticker, "b"));
				}
				else if(queryFlag.equals("l1")){ // price
					stock.setPrice(getStockValue(ticker, "l1"));
				}
				else if(queryFlag.equals("j1")){ // market cap
					stock.setMarketCap(getStockValue(ticker, "j1"));
				}
				else if(queryFlag.equals("e")){ // earnings per share
					stock.setEarningsPerShare(getStockValue(ticker, "e"));
				}
				else if(queryFlag.equals("j4")){ // ebitda
					stock.setEbitda(getStockValue(ticker, "j4"));
				}
				else if(queryFlag.equals("v")){ // volume
					stock.setVolume(getStockValue(ticker, "v"));
				}
				else if(queryFlag.equals("r")){ // pe ratio
					stock.setPe(getStockValue(ticker, "r"));
				}
				else if(queryFlag.equals("ex")){
					stock.setExchange(getStockValue(ticker, "ex"));
				}
				else if(queryFlag.equals("i")){
					stock.setInfo(getStockValue(ticker, "i"));
				}
				
			}
			catch(Exception e) {
				System.err.println(query + " is an invalid query");
			}
		}
		return stock;
	}
}
