package sa;

public class Customer {
	
	public float posx; //X component of position
	public float posy; //Y component of position
	
	public boolean[] products;  //Products this costumer wants
	// (ex: [true, false, false, true] = costumer wants products 0 and 3)
	
	public Customer(int posx, int posy, boolean[] products) {
		this.posx = posx;
		this.posy = posy;
		this.products = products;
	}

	private float distanceTo(Store store) {
		return (float) Math.sqrt(Math.pow(posx-store.posx, 2) + Math.pow(posy-store.posy, 2));
	}
	
	public float getUnhappiness(StoreMap map) {
		return 0; //TODO Define me
	}

}
