import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TickerNames {

	public String marketName;
	public ArrayList<String> stockNames;
	
	
	
	public TickerNames(String a)
	{
		this.marketName = a;
		this.stockNames = new ArrayList<String>();
		
	}
	
	
	public ArrayList<String> getStockNames()
	{
		try {
			File stockbyCompany = new File(marketName + ".txt");
			
			Scanner sc;
			
			sc = new Scanner(stockbyCompany);
			
			while(sc.hasNext())
			{
				String stockName = sc.nextLine();
				int a = 0;
				
		
				Boolean hasFound = false;
				for(int i = 0; !hasFound ; i++)
				{
					if(Character.isWhitespace(stockName.charAt(i)))
					{
						a = i;
				
						hasFound = true;
					}
				}
				
				String newString = stockName.substring(0, a);
				stockNames.add(newString);
			}
				sc.close();
			
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}	
		
		return stockNames;
		
	}
	
	
	
}
