import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class StockWindow  {

	public String stockInput;
	public String marketChoice;
	public static InputHandler hndl;
	
	@SuppressWarnings("static-access")
	public StockWindow()
	{
		this.stockInput = null;
		this.marketChoice = null;
		this.hndl = new InputHandler(this.marketChoice);
	}


	public static void generateWindow()
	{
	
		StockWindow.startRefresh();
		
		String[] marketNames = {"NYSE", "NASDAQ", "AMEX"};
	
		
		//Creates a Frame
		JFrame mainWindow = new JFrame("Stock Viewer");
		mainWindow.setSize(1280, 800);
		mainWindow.setVisible(true);
		
		
		
		
		//Creates text panel at the top with drop down menu for stock
		JPanel topMenu = new JPanel();
		JPanel midMenu = new JPanel();
		JPanel botMenu = new JPanel();
		
		
		//Market selection drop-down menu
		JLabel marketSelectionText = new JLabel("Market Name:");
		JComboBox<String> dropStocks = new JComboBox<String>(marketNames);
		dropStocks.setMaximumRowCount(3);
		
		//Search Bar For Stocks
		JTextField searchStock = new JTextField();
		searchStock.setColumns(50);
	
		
		JLabel stockSearchText = new JLabel("Stock Search:");
		
		
		//Refresh buttons for markets
		JButton refresh = new JButton("Refresh");
	
		
				
		
		
		//Topmenu
		topMenu.add(stockSearchText);
		topMenu.add(searchStock);
		topMenu.add(marketSelectionText);
		topMenu.add(dropStocks);
		
		
		//JTextArea for displaying price on stock
		JTextArea stockPriceDisplay = new JTextArea("");
		stockPriceDisplay.setEditable(false);
		
		
		
		//Midmenu
		midMenu.add(stockPriceDisplay);
		
		//Botmenu
		botMenu.add(refresh); 
		
		//Adds JPanels to window
		mainWindow.getContentPane().add(BorderLayout.NORTH, topMenu);
		mainWindow.getContentPane().add(BorderLayout.CENTER, midMenu);
		mainWindow.getContentPane().add(BorderLayout.SOUTH, botMenu);
		
		mainWindow.setVisible(true);
		
		
		
		//Actions for JComboBox and JTextField
		
		
		Action searchAction = new AbstractAction()
		{

					/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						String a = searchStock.getText();
						searchStock.setText(null);
						
						Double priceDoub = hndl.getPrice(a);
						
						
						if(priceDoub != 0.0)
						{	
							stockPriceDisplay.setText(a + ": " + Double.toString(priceDoub));
						}
						
						else
						{
							stockPriceDisplay.setText("Could not find the stock: " + a );
						}
						
					}
			
		};
		
		Action marketAction = new AbstractAction()
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent event) 
			{
				String selectedMarket =	dropStocks.getSelectedItem().toString();
				
				hndl.marketChoice = selectedMarket;
				
			}
			
		};
		
		Action refreshAction = new AbstractAction()
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				startRefresh();
				
			}
			
			
		};
		
		dropStocks.addActionListener(marketAction);
		searchStock.addActionListener(searchAction);
		refresh.addActionListener(refreshAction);
	}  
	
	public static void startRefresh()
	{
		
		
		JDialog waitBox = new JDialog();
		JTextField text = new JTextField("Please wait while we update " + hndl.marketChoice);
		
		text.setEditable(false);
		
		waitBox.setVisible(true);
		waitBox.toFront();
		waitBox.setSize(500, 150);
		waitBox.add(text);
		text.setHorizontalAlignment(JTextField.CENTER);
		
		
		
		Thread t1 = new Thread(new ThreadHandler());
		t1.start();
		
		waitBox.setVisible(false);
		
	}
	
	
	
}
