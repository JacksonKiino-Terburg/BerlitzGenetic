package net.berlitz.functions.populationBuilders;

import java.util.Random;

public class BinaryOrganismProvider implements organismProvider {
    int bitLength;
    long seed;
    Random rand;
    public BinaryOrganismProvider(int bitLength) {
        this.bitLength = bitLength;
        seed = System.currentTimeMillis();
        rand = new Random(seed);
    }
    public BinaryOrganismProvider(int bitLength, long seed) {
        this.bitLength = bitLength;
        this.seed = seed;
    }

    @Override
    public BinaryOrganism randOrganism(int timeOfCreation, int orgID) {
        return new BinaryOrganism(genRandomChromosome(bitLength), timeOfCreation, orgID) ;
    }

    private String genRandomChromosome(int bitLength) {
        String chromosome = "";
        for(int i = 0; i < bitLength; i++) {
            if(rand.nextBoolean()) chromosome += '1'; else chromosome += '0';
        }
        return chromosome;
    }
}
