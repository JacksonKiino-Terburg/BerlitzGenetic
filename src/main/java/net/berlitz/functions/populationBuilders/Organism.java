package net.berlitz.functions.populationBuilders;

public class Organism {
    public final Object Chromosome;
    public final int timeOfCreation;
    public final int id;
    public Organism(Object chromosome, int timeOfCreation, int id) {
        this.Chromosome = chromosome;
        this.timeOfCreation = timeOfCreation;
        this.id = id;
    }
}
