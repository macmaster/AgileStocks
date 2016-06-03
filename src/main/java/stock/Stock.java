/** Stock.java **
 * 
 * Author: Ronald Macmaster
 * 
 * Created on May 26, 2016
 * (c) Copyright IBM Corporation 2016
 * 
 *****************************************/
package stock;

/**
 * Data structure for the stock data type
 * @author ronny
 *
 */
public class Stock {

	private String name;
	private String ticker;
	private String price;
	private String pe;
	private String marketCap; 
	private String info;
	private String earningsPerShare;
	private String ebitda;
	private String ask;
	private String bid;
	private String volume;
	private String exchange;

	public Stock(String ticker) {
		this.ticker = ticker;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the marketCap
	 */
	public String getMarketCap() {
		return marketCap;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @return the earningsPerShare
	 */
	public String getEarningsPerShare() {
		return earningsPerShare;
	}

	/**
	 * @return the ebitda
	 */
	public String getEbitda() {
		return ebitda;
	}

	/**
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * @return the exchange
	 */
	public String getExchange() {
		return exchange;
	}

	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param ticker the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	/**
	 * @param marketCap the marketCap to set
	 */
	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @param earningsPerShare the earningsPerShare to set
	 */
	public void setEarningsPerShare(String earningsPerShare) {
		this.earningsPerShare = earningsPerShare;
	}

	/**
	 * @param ebitda the ebitda to set
	 */
	public void setEbitda(String ebitda) {
		this.ebitda = ebitda;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * @param exchange the exchange to set
	 */
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * @param pe the pe to set
	 */
	public void setPe(String pe) {
		this.pe = pe;
	}
	
	/**
	 * @param ask the ask to set
	 */
	public void setAsk(String ask) {
		this.ask = ask;
	}
	
	/**
	 * @param bid the bid to set
	 */
	public void setBid(String bid) {
		this.bid = bid;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return the pe
	 */
	public String getPe() {
		return pe;
	}

	/**
	 * @return the ask
	 */
	public String getAsk() {
		return ask;
	}

	/**
	 * @return the bid
	 */
	public String getBid() {
		return bid;
	}
}