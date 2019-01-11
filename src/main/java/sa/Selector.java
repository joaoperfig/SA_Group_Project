package sa;
import java.util.ArrayList;

public abstract class Selector{
	// Method for selecting mating pool from population
	
    public abstract ArrayList<Individual> select(Population p, int quantity); 

}
