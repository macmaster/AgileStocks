/** Pair.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on Jun 2, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package app;

/**
 * A pair of two objects
 * @author ronny
 *
 */
public class Pair<L, R> {

	/**
	 * The pair's first item.
	 */
	public L left;
	
	/**
	 * The pair's second item.
	 */
	public R right;
	
	/**
	 * Create a Object pair of two items.
	 * 
	 * @param first the first item in the pair.
	 * @param second the second item in the pair.
	 */
	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

}
