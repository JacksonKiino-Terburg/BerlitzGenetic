package net.berlitz.mutators;

import net.berlitz.populationBuilders.BinaryOrganism;
import net.berlitz.populationBuilders.Population;

public class BinaryMutator {
    public static BinaryOrganism mutate(Population population, BinaryOrganism organism) {
        String chromosome = (String) organism.Chromosome;
        int bitToFlip = population.rand.nextInt(chromosome.length());

        //flip bit
        if(chromosome.charAt(bitToFlip) == '1') { chromosome = chromosome.substring(0, bitToFlip) + '0' + chromosome.substring(bitToFlip + 1); }
        else {chromosome = chromosome.substring(0, bitToFlip) + '1' + chromosome.substring(bitToFlip + 1); }

        organism.setChromosome(chromosome);
        return organism;
    }
}
