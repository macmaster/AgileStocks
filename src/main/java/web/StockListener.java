package web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.DBAccess;
import stock.Stock;
import app.StockBean;

/**
 * Restuful API for StockService
 */
@Path("/")
public class StockListener {

	/**
	 * Stock bean to handle application layer processing
	 */
	private StockBean bean = new StockBean();

	@GET
	@Path("{ticker}")
	@Produces("text/html")
	public String getStockResponse(@PathParam("ticker") String ticker,
			@DefaultValue("p") @QueryParam("q") final String queryString) throws IOException {
		System.err.println("inside get request");
		List<String> querys = Arrays.asList(queryString.split("[+, ]"));
		String value = bean.processQueries(ticker, querys);
		return value;
	}

	/** Webpage post response */
	/*@POST
	@Path("/{ticker}")
	@Produces("text/html")
	@Consumes("application/x-www-form-urlencoded")
	public String postStockResponse(@PathParam("ticker") String ticker,
									@FormParam("querys") List<String> querys,
									@DefaultValue("false") @FormParam("save") Boolean save) throws IOException {
		System.err.println("Servicing post request.");
		String value = bean.processQueries(ticker, querys);
		return value;
	}*/
	
	/** JSON post response */
	@POST
	@Path("/{ticker}")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Stock postStockResponse(@PathParam("ticker") String ticker,
			@FormParam("querys") List<String> querys,
			@DefaultValue("false") @FormParam("save") Boolean save) throws IOException {
			System.err.println("Servicing post request.");
			Stock jsonStock = bean.processQueriesJSON(ticker, querys);
			if(save){DBAccess.store(jsonStock);}
			return jsonStock;
	}
	
	/** put json response */
	@PUT
	@Produces("application/json")
	public Stock putStockResponse(String ticker){
		Stock stock = bean.buildStockJSON(ticker);
		return stock;
	}
	

}
