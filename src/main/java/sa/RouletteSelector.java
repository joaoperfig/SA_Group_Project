package sa;

import java.util.ArrayList;
import java.util.Random;

public class RouletteSelector extends Selector {

	@Override
	public ArrayList<Individual> select(Population p, int quantity) {

		Random random = new Random();
		int totalFitness = 0;
		ArrayList<Individual> individuals = new ArrayList<Individual>();
		for (int i = 0; i < p.populationSize(); i++) {
			totalFitness += p.getIndividual(i).getFitness();
		}

		for (int i = 0; i < quantity; i++) {

			// pick a random number between 0 and that sum.
			int randomNumber = random.nextInt(totalFitness + 1);

			int runningSum = 0;
			int index = 0;
			int lastAddedIndex = 0;
			while (runningSum < randomNumber) {
				runningSum += p.getIndividual(index).getFitness();
				lastAddedIndex = index;
				index++;
			}
			individuals.add(p.getIndividual(lastAddedIndex));
			runningSum = 0;
			index = 0;
			lastAddedIndex = 0;
		}

		return individuals;

	}

}
