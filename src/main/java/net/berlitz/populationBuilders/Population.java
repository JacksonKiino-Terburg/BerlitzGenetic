package net.berlitz.populationBuilders;

import java.util.HashMap;
import java.util.Random;

public class Population {
    HashMap<Integer, Organism> wholePop;
    int popSize;
    float mutationRate;
    float crossoverRate;
    int age = 0;
    int currID = 0;
    organismProvider organismProvider;
    Random rand;
    long seed;

    public Population(int popSize, float mutationRate, float crossoverRate, organismProvider organismProvider) {
        wholePop = initializePopulation();
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.organismProvider = organismProvider;
        seed = System.currentTimeMillis();
        rand = new Random(seed);
    }

    public Population(int popSize, float mutationRate, float crossoverRate, organismProvider organismProvider, long seed) {
        wholePop = initializePopulation();
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.organismProvider = organismProvider;
        this.seed = seed;
        rand = new Random(seed);
    }

    public HashMap<Integer, Organism> initializePopulation() {
        HashMap<Integer, Organism> population = new HashMap<>();
        for (int i = 0; i < popSize; i++) {
            Organism randOrg = organismProvider.randOrganism(age, currID++);
            population.put(randOrg.id, randOrg);
        }
        return population;
    }
}
