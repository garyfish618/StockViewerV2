// This class is in charge of fetching market updates on seperate thread
public class ThreadHandler implements Runnable {

	@Override
	public void run() {
		System.out.println("Starting");
		InputHandler.refreshMarket();
		
	}

}
