import java.util.ArrayList;

public class PricesTable {

	private static HashTable<String, Double> NYSE;
	private static HashTable<String, Double> NASDAQ; 
	private static HashTable<String, Double> AMEX;
	
	private final String PRICE_BEGINNING = "https://api.iextrading.com/1.0/stock/";
	private final String PRICE_ENDING = "/quote";
	
	public PricesTable()
	{
		PricesTable.NYSE = new HashTable<String, Double>(3159);
		PricesTable.NASDAQ = new HashTable<String, Double>(3370);
		PricesTable.AMEX =  new HashTable<String, Double>(2151);
	}
	
	
	public void refresh(String b)
	{
		StockPriceFetch a;
		
		if(b.equals("NYSE"))
		{
			//Populating NYSE
					TickerNames nyseList = new TickerNames("NYSE");
					ArrayList<String> nyseTickers = nyseList.getStockNames();
					
					
					
					for(int i = 0; i < nyseTickers.size(); i++)
					{
						String tickerName = nyseTickers.get(i);
						
						a = new StockPriceFetch(PRICE_BEGINNING + tickerName + PRICE_ENDING);
						
						Double price = a.getPrice();
						
						NYSE.put(tickerName, price);
						
						
					}
					System.out.println("NYSE Done");
		}
		
		if(b.equals("AMEX"))
		{
				//Populating AMEX
						TickerNames amexList = new TickerNames("AMEX");
						ArrayList<String> amexTickers = amexList.getStockNames();
						
						
						for(int i = 0; i < amexTickers.size(); i++)
						{
							String tickerName = amexTickers.get(i);
							
							a = new StockPriceFetch(PRICE_BEGINNING + tickerName + PRICE_ENDING);
							
							Double price = a.getPrice();
							
							AMEX.put(tickerName, price);
							
							
						}
						
						System.out.println("AMEX Done");
		}
		
		if(b.equals("NASDAQ"))
		{
				//Populating NASDAQ
						TickerNames nasdaqList = new TickerNames("NASDAQ");
						ArrayList<String> nasdaqTickers = nasdaqList.getStockNames();
						
						
						for(int i = 0; i < nasdaqTickers.size(); i++)
						{
							String tickerName = nasdaqTickers.get(i);
							
							a = new StockPriceFetch(PRICE_BEGINNING + tickerName + PRICE_ENDING);
							
							Double price = a.getPrice();
							
							NASDAQ.put(tickerName, price);
							
							
						}
						System.out.println("NASDAQ Done");		
			}
		}
	
	public Double getPrice(String a, String b)
	{
		switch(a){
		
			case "NYSE":
			{
				if(NYSE.get(b) != null)
				{
				return NYSE.get(b);
				}
				
				return 0.0;
			}
			
			case "AMEX":
			{
				if(AMEX.get(b) != null)
				{
					return NYSE.get(b);
				}
				
				return 0.0;
			}
			
			case "NASDAQ":
			{
				if(NASDAQ.get(b) != null)
				{
					return NASDAQ.get(b);
				}
				
				return 0.0;	
			}
			
			default: return 0.0;
		
		}
		
			
	}
	
	
	
}
