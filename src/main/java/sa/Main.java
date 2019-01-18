package sa;

public class Main {
	public static void main(String[] args){
		
		int populationSize = 400;
		int matingPoolSize = 50;
		int epochs = 1000;
		Mutator mutator = new NormalGaussMutator(0.7f, 0.1f);     
		CrossoverMethod cross = new ArithmeticCross(0.7f);
		Selector selector = new RouletteSelector();         
		
		Evolver ev = new Evolver();
		Population initialp = new Population(populationSize);
		for (int i =0; i<populationSize ;i++) {
			initialp.addIndividual(new Individual(new StoresPhenotype()));
		}
		Population finalpop = ev.runCycles(epochs, initialp, mutator, cross, selector, matingPoolSize);
	}

}
