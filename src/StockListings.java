
import java.util.ArrayList;

public class StockListings {

	public static ArrayList<String> stockNames = new ArrayList<String>();
	public static int amountofStocks = 0;
	
	public StockListings()
	{
		

	}
	
	public void addStock(String stockName)
	{
		StockListings.stockNames.add(stockName);
		StockListings.amountofStocks++;
		
	}

	public String[] stockArray()
	{
		String[] stocks = new String[amountofStocks];
		
		for(int i = 0; i < stocks.length; i++)
		{
			stocks[i] = stockNames.get(i);
		}
		
		return stocks;
		
	}
	
	
}
