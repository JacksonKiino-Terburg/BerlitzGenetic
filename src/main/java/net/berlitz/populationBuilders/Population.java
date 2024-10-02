package net.berlitz.populationBuilders;

import java.util.HashMap;
import java.util.Random;

public class Population {
    HashMap<Integer, BinaryOrganism> wholePop;
    int popSize;
    float mutationRate;
    float crossoverRate;
    public int age = 0;
    public int currID = 0;
    BinaryOrganismProvider organismProvider;
    public Random rand;
    long seed;

    public Population(int popSize, float mutationRate, float crossoverRate, BinaryOrganismProvider organismProvider) {
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.organismProvider = organismProvider;
        this.seed = System.currentTimeMillis();
        this.rand = new Random(seed);
        this.wholePop = initializePopulation();
    }

    public Population(int popSize, float mutationRate, float crossoverRate, BinaryOrganismProvider organismProvider, long seed) {
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.organismProvider = organismProvider;
        this.seed = seed;
        this.rand = new Random(seed);
        this.wholePop = initializePopulation();
    }

    public HashMap<Integer, BinaryOrganism> initializePopulation() {
        HashMap<Integer, BinaryOrganism> population = new HashMap<>();
        for (int i = 0; i < popSize; i++) {
            BinaryOrganism randOrg = organismProvider.randOrganism(age, currID++, rand);
            population.put(randOrg.id, randOrg);
        }
        return population;
    }

    public HashMap<Integer, BinaryOrganism> getWholePop() {
        return wholePop;
    }

    public void setPopulation(HashMap<Integer, BinaryOrganism> population) {
        this.wholePop = population;
    }
}
