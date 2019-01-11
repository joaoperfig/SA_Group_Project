package sa;

public class ArithmeticCross extends CrossoverMethod{

	private float rate;

	public ArithmeticCross(float rate) {
		this.rate=rate;
	}
	
	public Genotype cross(Genotype g1, Genotype g2) {
		RealVectorGenotype bg1 = (RealVectorGenotype)g1;
		RealVectorGenotype bg2 = (RealVectorGenotype)g2;
		RealVectorGenotype bg = new RealVectorGenotype(bg1.getSize());
		if(Math.random() <= rate) {
			float relativePosition = (float) Math.random();
			for(int i = 0; i < bg.getSize(); i++) {
				bg.content.add((bg1.content.get(i)*relativePosition) + (bg2.content.get(i)*(1-relativePosition)));
			}
			return bg;
		}
		else {
			if (Math.random() <= 0.5)
				return bg1;
			else
				return bg2;
		}
	}
}
