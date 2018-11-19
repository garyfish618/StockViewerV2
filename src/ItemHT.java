//This class defines a HashTable item using a key and the actual value

public class ItemHT<T1, T2> {

	public T1 key;
	public T2 value;
	
	
	public ItemHT()
	{
		this(null,null);
	}
	
	public ItemHT(T1 a, T2 b)
	{
		this.key = a;
		this.value = b;
	}
	
	
	
	
	
	
	
}
