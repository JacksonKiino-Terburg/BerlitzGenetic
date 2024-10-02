package net.berlitz.crossover;

import net.berlitz.populationBuilders.BinaryOrganism;
import net.berlitz.populationBuilders.Population;

public class BinarySinglePointCrossover {
    public static BinaryOrganism[] crossover(Population population, BinaryOrganism parent1, BinaryOrganism parent2) {
        int crossoverPoint = population.rand.nextInt(((String) parent1.Chromosome).length()-1)+1;
        BinaryOrganism child1 = new BinaryOrganism(((String) parent1.Chromosome).substring(0, crossoverPoint) + ((String) parent2.Chromosome).substring(crossoverPoint),
                population.age, population.currID++);
        BinaryOrganism child2 = new BinaryOrganism(((String) parent2.Chromosome).substring(0, crossoverPoint) + ((String) parent1.Chromosome).substring(crossoverPoint),
                population.age, population.currID++);

        BinaryOrganism[] crossovers = {child1, child2};
        return crossovers;
    }
}
