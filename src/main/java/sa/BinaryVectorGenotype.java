package sa;

import java.util.ArrayList;

public class BinaryVectorGenotype extends Genotype{

	private int size;
	public ArrayList<Boolean> content;

	public BinaryVectorGenotype(int size) {
		super();
		this.size = size;
		content = new ArrayList<Boolean>(size);
	}

	public int getSize() {
		return size;
	}
}
