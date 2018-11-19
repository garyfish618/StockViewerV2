import java.util.ArrayList;

// This class identifies how different statistics of each stock is stored

public class HashTable<T1, T2> {

	private ArrayList<ItemHT<T1, T2>>[] arr;


	public HashTable()
	{
		this(100);
	}
		
	
	@SuppressWarnings("unchecked")
	public HashTable(int sz)
	{
		this.arr = new ArrayList[sz];
		
		
		for(int i = 0; i < this.arr.length; i++)
		{
			this.arr[i] = new ArrayList<ItemHT<T1,T2>>();
			
		}
	}
	
	
	public void put(T1 testKey, T2 newValue)
	{
		int hc = testKey.hashCode();
		
		 hc = Math.abs(hc % this.arr.length);
		
		 ArrayList<ItemHT<T1,T2>> hcArrayList = this.arr[hc];
		 
		 for(int i = 0; i < hcArrayList.size(); i++)
		 {
			 ItemHT<T1, T2> currItem = hcArrayList.get(i);
			 
			 if(currItem.key.equals(testKey))
			 {
				 currItem.value = newValue;
				 
				 return;
				 
			 }
		 }
		
		 
		 ItemHT<T1, T2> newItem = new ItemHT<T1, T2>(testKey, newValue);
				 
		 hcArrayList.add(newItem);
	}
	
	
	public T2 get(T1 keyToGet)
	{
		int hc = Math.abs(keyToGet.hashCode() % this.arr.length);
		
		ArrayList<ItemHT<T1, T2>> hcArrayList = this.arr[hc];
				
		for(int i = 0; i < hcArrayList.size(); i++)
		{
			ItemHT<T1, T2> itemtoCompare = hcArrayList.get(i);
			
			if(itemtoCompare.key.equals(keyToGet)) return itemtoCompare.value;
			
		}
		
		return null;
		
	}
	
	
	public int getSize()
	{
		return arr.length;
	}
	
	
}
