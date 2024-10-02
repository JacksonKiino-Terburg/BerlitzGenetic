package net.berlitz.populationBuilders;

public class Organism {
    public Object Chromosome;
    public final int timeOfCreation;
    public final int id;
    public long fitness;
    public Organism(Object chromosome, int timeOfCreation, int id) {
        this.Chromosome = chromosome;
        this.timeOfCreation = timeOfCreation;
        this.id = id;
        this.fitness = 0;
    }

    public void setChromosome(Object chromosome) {
        this.Chromosome = chromosome;
    }

    public void setFitness(long fitness) {
        this.fitness = fitness;
    }

    public long getFitness() {
        return fitness;
    }
}
