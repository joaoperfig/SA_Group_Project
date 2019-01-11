package sa;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Evolver {
	private float epoch;
	public Population runCycles(float eps, Population population, Mutator mutator, CrossoverMethod cross, Selector selector, int matingPoolSize) {
		epoch = 0;
		ArrayList<Individual> matingpool = null;
		Population aux = null;
		Constructor<? extends Phenotype> phenocons = null;
		PrintWriter out = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		String filename = "log_"+dateFormat.format(date)+".txt";
		try {
			out = new PrintWriter(filename);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			phenocons = population.getIndividual(0).getPhenotype().getClass().getConstructor(Genotype.class);
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("WARNING: No constructor of phenotype from genotype");
			e.printStackTrace();
		}
		while (epoch < eps) {
			 System.out.println();
			 System.out.println("Population fitness BEST: "+population.getFittest().getFitness());
			 out.println(population.getFittest().getFitness());
			 epoch++;
			 matingpool = selector.select(population, matingPoolSize);
			 
			 //TEST
			 float sum = 0;
			 for (int i = 0; i < population.populationSize(); i++) {
				 sum += population.getIndividual(i).getFitness();
			 }
			 System.out.println("Population fitness AVG: "+ (sum/population.populationSize()));
			 
			 sum = 0;
			 for (int i = 0; i < matingpool.size(); i++) {
				 sum += matingpool.get(i).getFitness();
			 }
			 System.out.println("Mating fitness AVG: "+ (sum/matingpool.size()));
			 //TEST
			 
			 
			 
			 aux = new Population((population).populationSize());
			 for(int i = 0; i < population.populationSize(); i++) {
				 int a1 = (int) Math.random()*matingpool.size();
				 int a2 = (int) Math.random()*matingpool.size();
				 
				 Individual I1 = matingpool.get(a1);
				 Individual I2 = matingpool.get(a2);
				 Genotype ng = mutator.mutate(cross.cross(I1.getGenotype(), I2.getGenotype()));
				 Individual I3 = null;
				try {
					I3 = new Individual(phenocons.newInstance(ng));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					System.out.println("WARNING: Problem with using Phenotype Constructor.");
					e.printStackTrace();
				}
				 aux.addIndividual(I3);		 
			 }
			 population = aux;
		}
		out.close();
		System.out.println("Log file exported to "+filename);
		return aux;
	}
}
