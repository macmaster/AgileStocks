package web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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

	@POST
	@Produces("text/html")
	@Consumes("application/x-www-form-urlencoded")
	public String postStockResponse(@FormParam("stock") String ticker, @FormParam("querys") List<String> querys) throws IOException {
		System.err.println("Servicing post request.");
		String value = bean.processQueries(ticker, querys);
		return value;
	}

}
