/** TestStockBean.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on Jun 2, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package stock;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import app.StockBean;

/**
 * test file for the Stock Bean class
 * @author ronny
 *
 */
public class TestStockBean {
	/**
	 * stock bean object to test.
	 */
	public StockBean bean;

	/**
	 * initialize the test cases
	 */
	@Before
	public void init() {
		bean = new StockBean();
	}
	
	/*@Test
	public void TestProcessQueriesJSON() throws FileNotFoundException{
		System.out.println("testing JSON");
		System.out.println(bean.processQueriesJSON());
	}*/

}
