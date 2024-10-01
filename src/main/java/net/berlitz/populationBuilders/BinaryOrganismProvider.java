package net.berlitz.populationBuilders;

import java.util.Random;

public class BinaryOrganismProvider implements organismProvider {
    int bitLength;
    Random rand;
    public BinaryOrganismProvider(int bitLength, Random rand) {
        this.bitLength = bitLength;
        this.rand = rand;
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
