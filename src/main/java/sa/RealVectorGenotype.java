package sa;

import java.util.ArrayList;

public class RealVectorGenotype extends Genotype {

	private int size;
	ArrayList<Float> content;

	public RealVectorGenotype(int size) {
		super();
		this.size = size;
		content = new ArrayList<Float>(size);
	}

	public int getSize() {
		return size;
	}
}
