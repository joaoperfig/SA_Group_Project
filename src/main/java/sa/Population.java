package sa;

import java.util.ArrayList;

public class Population {
	private ArrayList<Individual> population;
	public float fittest;
	public Population(int size) {
		population = new ArrayList<Individual>(size);
		fittest = 0;
	}
	
	public void addIndividual(Individual indi) {
		population.add(indi);
	}
	
	public Individual getFittest() {
		this.fittest = 0;
		Individual fittest = population.get(0);
		for (int i = 0; i < population.size(); i++) {
			if (fittest.getFitness() <= population.get(i).getFitness()) {
				fittest = population.get(i);
			}
		}
		this.fittest = fittest.getFitness();
		return fittest;
	}
	/*
	public float getFitness() {
		float fitness = 0;
		for (int i = 0; i < population.size(); i++) {
			fitness += population.get(i).getFitness();
		}
		return fitness;
	}
	*/
	public Individual getIndividual(int index) {
		return population.get(index);
	}
	
	public int populationSize() {
		return population.size();
	}

}
