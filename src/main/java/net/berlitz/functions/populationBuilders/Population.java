package net.berlitz.functions.populationBuilders;

import java.util.HashMap;

public class Population {
    HashMap<Integer, Organism> wholePop;
    int popSize;
    float mutationRate;
    float crossoverRate;
    int age = 0;
    int currID = 0;
    BinaryOrganismProvider organismProvider;

    public Population(int popSize, float mutationRate, float crossoverRate, BinaryOrganismProvider organismProvider) {
        wholePop = initializePopulation();
        this.popSize = popSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.organismProvider = organismProvider;
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
