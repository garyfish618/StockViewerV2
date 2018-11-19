import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;


public class StockPriceFetch {

	public String url;
	
	
	public StockPriceFetch(String urltoPull)
	{
		this.url = urltoPull;

		
		
	}
	
	
	
	
	
	public double getPrice()
	{
		try{
			URL pullLink = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) pullLink.openConnection();
			
			int responseCode = conn.getResponseCode();
			
			if(responseCode == 401)
			{
				throw new Exception();
			}
			
			BufferedReader in = 
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine;
			
			StringBuffer response = new StringBuffer();
					
			while( (inputLine = in.readLine()) != null )   // Sets inputLine equal to next line in the buffer
			{
				response.append(inputLine); // Combines all the text placed in inputLine to one string that has to be pulled from later 
				
				
			}  
				 
			in.close();
			
			
			JSONObject mainData = new JSONObject(response.toString());
			
			double pricetoReturn = mainData.getDouble("latestPrice");
				
			return pricetoReturn;
		}
		
		catch(Exception e)
		{
			System.out.println(url);
			return 0;
		}
		
		
		
	}
	
	
	
	
	
	
}
