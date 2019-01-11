package sa;

public class NormalGaussMutator extends Mutator {
	
private float rate;
private float mean;
	
	public NormalGaussMutator(float rate, float mean) {
		this.rate= rate;
		this.mean= mean;
	}

	@Override
	public Genotype mutate(Genotype g) {
		RealVectorGenotype bg = (RealVectorGenotype)g;
		float r, x, y;
	      
	      // find a uniform random point (x, y) inside unit circle
	      do {
	         x = (float) (2.0 * Math.random() - 1.0);
	         y = (float) (2.0 * Math.random() - 1.0);
	         r = x*x + y*y;
	      } while (r > 1 || r == 0);    // loop executed 4 / pi = 1.273.. times on average
	                                    // http://en.wikipedia.org/wiki/Box-Muller_transform

	  
	      // apply the Box-Muller formula to get standard Gaussian z    
	      float z = (float) (x * Math.sqrt(-2.0 * Math.log(r) / r));
	      z = z*mean;

		if(Math.random() <= rate) {
			for(int i = 0; i < bg.getSize(); i++) {
				bg.content.set(i, bg.content.get(i)+ z);
			}
		}
		return bg;
	}

}
