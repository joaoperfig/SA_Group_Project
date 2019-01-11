package sa;

public class Store {
	
	public float posx; //X component of position
	public float posy; //Y component of position
	
	public boolean[] products;  //Products carried by this store 
	// (ex: [true, false, false, true] = store carries products 0 and 3)
	public float [] prices; //Prices of products
	// (ex: [3.45, 0, 0, 1.19] = product 0 costs 3,45)
	
	public Store(boolean[] products, float[] prices) {
		this.products = products;
		this.prices = prices;
	}

}
