package sa;

import java.util.ArrayList;

public class BestSelector extends Selector {
	// Selects the top individuals;
	
	@Override
	public ArrayList<Individual> select(Population p, int quantity) {
		ArrayList<Integer> selectedIDs = new ArrayList<Integer>();
		for (int q=0; q<quantity; q++) {
			float bestFitness = 0;
			Integer bestID = null;
			
			for (int i=0; i<p.populationSize(); i++) {
				if ((p.getIndividual(i).getFitness()>=bestFitness) && (!selectedIDs.contains(i))) {
					bestID = i;
					bestFitness = p.getIndividual(i).getFitness();
				}
			}
			
			selectedIDs.add(bestID);
		}
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		for (Integer i : selectedIDs) {
			individuals.add(p.getIndividual(i));
		}
		return individuals;
	}

}
