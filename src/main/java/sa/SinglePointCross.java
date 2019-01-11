package sa;

public class SinglePointCross extends CrossoverMethod {
	
	private float rate;
	
	public SinglePointCross(float rate) {
		this.rate=rate;
	}
	
	public Genotype cross(Genotype g1, Genotype g2) {
		BinaryVectorGenotype bg1 = (BinaryVectorGenotype)g1;
		BinaryVectorGenotype bg2 = (BinaryVectorGenotype)g2;
		BinaryVectorGenotype newGen = new BinaryVectorGenotype(bg1.getSize());
	    if (Math.random() <= rate){
      		int pos = (int) (Math.random() * bg1.getSize());
			for (int i = 0; i<pos;i++){
            	newGen.content.add(i, bg1.content.get(i));
            }
          	for (int i = pos; i<bg1.getSize();i++){
            	newGen.content.add(i, bg2.content.get(i));
            } 
          	return newGen;
        }
      	if(Math.random()>0.5){ 
        	return bg1;
        } else {
        	return bg2;
        }
	    
	}
}
