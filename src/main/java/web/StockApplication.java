/** StockApplication.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on May 31, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Top  Level container for the Stock Listener Application
 * @author ronny
 *
 */
@ApplicationPath("/stock")
public class StockApplication extends Application {

	/**
	 * 
	 */
	public StockApplication() {
		// TODO Auto-generated constructor stub
	}

}
