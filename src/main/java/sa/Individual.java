package sa;

public class Individual {

	private Phenotype phenotype;
	private Genotype genotype;
	private float fitness;

	public Individual(Phenotype phenotype) {
		this.phenotype = phenotype;
		this.genotype = phenotype.encode();
		fitness = phenotype.evaluate();
	}

	public float getFitness() {
		return fitness;
	}

	public Phenotype getPhenotype() {
		return phenotype;
	}

	public Genotype getGenotype() {
		return genotype;
	}


}