package sa;
import java.util.ArrayList;

public class StoreMap {
	
	public float lenx; //map width
	public float leny; //map height
	// Objects can be in positions ([0, lenx], [0, leny])
	
	public ArrayList<Customer> customers; //Customers in this map
	public ArrayList<Store> stores; //Stores in this map
	
	public StoreMap() {
		
	}
	
	public float getTotalUnhappiness() {
		float total = 0;
		for (Customer customer : customers) {
			total += customer.getUnhappiness(this);
		}
		return total;
	}

}
