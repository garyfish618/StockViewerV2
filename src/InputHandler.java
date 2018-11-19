
public class InputHandler {
	public static String marketChoice;
	public static PricesTable mainTable;
	
	
	public InputHandler(String a)
	{
		
		mainTable = new PricesTable();
		marketChoice = "NYSE";
		
	}
	
	
	public double getPrice(String stockName)
	{
		Double price =	mainTable.getPrice(marketChoice, stockName);
				
		return price;
		
	}
	
	public static void refreshMarket()
	{
		mainTable.refresh(marketChoice);
		
	}
	
	
	
	
	
}
