/** DBAccess.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on Jun 3, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package dao;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import stock.Stock;

/**
 * static class to store data in my couch db database
 * @author ronny
 *
 */
public class DBAccess {
	
	public static void main(String[] args){
		CouchDbProperties properties = new CouchDbProperties();
		properties.setDbName("agilestocks");
		properties.setHost("localhost");
		CouchDbClient dbClient = new CouchDbClient(); 
	}

	/** store
	 * 
	 * stores json stock data in the NoSQL couch db 
	 * @param stock json stock data to store in the couch DB
	 */
	public static void store(Stock stock){
		System.out.println("Storing the stock in the database");
		CouchDbClient dbClient = new CouchDbClient(); 
		dbClient.save(stock);
	}

}
