package sa;
import java.util.ArrayList;

public class StoreMap {
	
	public static StoreMap instance = null; //singleton
	
	public float lenx; //map width
	public float leny; //map height
	// Objects can be in positions ([0, lenx], [0, leny])
	public int storesNumber;
	public int peopleNumber;
	
	public ArrayList<Customer> customers; //Customers in this map
	public ArrayList<Store> stores; //Stores in this map
	
	public StoreMap(float width, float height, int peopleNumber, int productsNumber, int storesNumber) {
		
		customers = new ArrayList<Customer>();
		stores = new ArrayList<Store>();
		this.peopleNumber = peopleNumber;
		this.storesNumber = storesNumber;
		
		for(int i=0; i<peopleNumber; i++) {
			
			Customer c = new Customer(randomWithRangeFloat(0, width),randomWithRangeFloat(0, height),makeProducts(productsNumber));
			customers.add(c);
			
		}
		
		for(int i=0; i<storesNumber; i++) {
			
			Store s = new Store(makeProducts(productsNumber), makePrices(productsNumber));
			stores.add(s);
		}
		
		// CREATE LIST OF COSTUMERS IN RANDOM POSITIONS (positions go from 0 to width and 0 to height)
		// CREATE LIST OF STORES WITH RANDOM PRODUCTS AND RANDOM PRICES
	}
	
	public static StoreMap getInstance() {
		if (instance == null) {
			instance = new StoreMap(40, 40, 10, 4, 4);
		}
		return instance;
	}
	
	public float getTotalUnhappiness() {
		float total = 0;
		for (Customer customer : customers) {
			total += customer.getUnhappiness(this);
		}
		return total;
	}
	
	// MAX Price is 5
	// MIN Price is 0.1
	public float[] makePrices(int numOfProducts) { 
		
		float[] prices = new float[numOfProducts];
		
		for(int i=0; i<numOfProducts; i++) {
			prices[i] = randomWithRangeFloat((float)(0.1), (float)(5.0));
		}
		return prices;
	}
	
	public boolean[] makeProducts(int numOfProducts) {
		
		boolean[] products = new boolean[numOfProducts];
		
		for(int i=0; i<numOfProducts; i++) {
			products[i] = (1 == randomWithRange(0, 1));
		}
		
		return products;
	}
	
	public float randomWithRangeFloat(float min, float max)
	{
		double random = min + Math.random() * (max - min);
		return (float)(random);
		
	}
	
	
	public int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

}
