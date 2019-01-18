package sa;

import java.util.ArrayList;

public class StoresPhenotype extends Phenotype {
	
	private int size;
	private ArrayList<Float> storePositions;
	private StoreMap storemap;
	
	public StoresPhenotype() { //Construct Phenotype from random parameters (for initial population)
		this.storemap = StoreMap.getInstance();
		this.size = storemap.storesNumber * 2;
		this.storePositions = new ArrayList<Float>(size);
		for (int i =0; i<storemap.storesNumber;i++) {
			storePositions.add((float) Math.random()*storemap.lenx);
			storePositions.add((float) Math.random()*storemap.leny);
		}
	}
	
	public StoresPhenotype(Genotype genotype) { //Decode Genotype and construct Phenotype from it
		RealVectorGenotype rg = (RealVectorGenotype)genotype;
		this.storemap = StoreMap.getInstance();
		this.size = storemap.storesNumber * 2;
		this.storePositions = new ArrayList<Float>(size);
		for (int i =0; i<size;i++) {
			storePositions.add(rg.content.get(i));
		}
	}

	@Override
	public Genotype encode() {
		RealVectorGenotype rg = new RealVectorGenotype(size);
		for (int i =0; i<size;i++) {
			rg.content.add(storePositions.get(i));
		}
		return rg;
	}

	@Override
	public float evaluate() {
		for (int i =0; i<storemap.storesNumber;i++) {
			int x = i*2;
			int y = (i*2)+1;
			storemap.stores.get(i).posx = storePositions.get(x);
			storemap.stores.get(i).posy = storePositions.get(y);
		}
		return storemap.getTotalUnhappiness();
	}

}
