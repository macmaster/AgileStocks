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

/**
 * Application Layer Class to handle the Stock Computations/fetching
 * @author ronny
 *
 */
public class StockBean {

	/**
	 * 
	 */
	public StockBean() {
		// TODO Auto-generated constructor stub
	}
	
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

}
