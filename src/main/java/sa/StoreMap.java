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

}
