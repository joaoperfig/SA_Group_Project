package sa;
import java.util.ArrayList;

public class Temp {

	public static void main(String[] args) {
		
		StoreMap s = new StoreMap(10, 10, 7, 7, 7);
		
		for(int i=0; i<s.customers.size(); i++) {
			
			System.out.println("posx " + s.customers.get(i).posx + " posy "+ s.customers.get(i).posy);
			
			for(int j=0; j< s.customers.get(i).products.length; j++)
				System.out.println(s.customers.get(i).products[j]);
			
		}

		for(int i=0; i<s.stores.size(); i++) {
			
			for(int j=0; j<s.stores.get(i).products.length; j++) {
				System.out.println(s.stores.get(i).products[j]);
				System.out.println(s.stores.get(i).prices[j]);
			}
			
			
				

			
		}
		
		
		
	}

}
