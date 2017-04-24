package edu.ilstu.program4;

import yahoofinance.*; // import yahoofinance.YahooFinance;
import java.io.IOException;
import java.math.BigDecimal;

public class PortfolioPrices {

	public static double getPrice(String symbol) {

		BigDecimal price = new BigDecimal(0);

		// by specifying yahoofinance here, we can use ‘Stock’ name
		// for our own class without conflict between classes named 'Stock’
		yahoofinance.Stock stock = null;
		try {

			stock = YahooFinance.get(symbol);
			price = stock.getQuote().getPrice();
		} catch (IOException e1) {
			System.out.println("Couldn't connect to server.");
		}
		return price.doubleValue();
	}
}
