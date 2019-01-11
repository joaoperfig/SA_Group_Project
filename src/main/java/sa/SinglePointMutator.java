package sa;

public class SinglePointMutator extends Mutator{
	
	private float rate;
	
	public SinglePointMutator(float rate) {
		this.rate= rate;
	}
	
	
	public Genotype mutate(Genotype g) {
		BinaryVectorGenotype bg = (BinaryVectorGenotype)g;
	    if (Math.random() <= rate) {
        	int pos = (int) (Math.random() * bg.getSize());
	        Boolean gene = !bg.content.get(pos);
	        bg.content.set(pos, gene);
	    }
	    
	    return bg;
	}

}
