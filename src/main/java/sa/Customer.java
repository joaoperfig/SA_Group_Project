package sa;

public class Customer {
	
	public float posx; //X component of position
	public float posy; //Y component of position
	
	public Customer(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}

	private float distanceTo(Store store) {
		return (float) Math.sqrt(Math.pow(posx-store.posx, 2) + Math.pow(posy-store.posy, 2));
	}
	
	public float getUnhappiness(StoreMap map) {
		return 0; //TODO Define me
	}

}
