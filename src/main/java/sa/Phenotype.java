package sa;

public abstract class Phenotype{

    public Phenotype (){ //Construct Phenotype from random parameters (for initial population)

    }

    public Phenotype (Genotype genotype){ //Decode Genotype and construct Phenotype from it
    }

    public abstract Genotype encode(); //Encode Phenotype into Genotype

    public abstract float evaluate ();

}
