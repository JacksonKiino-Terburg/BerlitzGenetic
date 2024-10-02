package net.berlitz.populationBuilders;

import java.util.Random;

public class BinaryOrganismProvider implements organismProvider {
    int bitLength;
    public BinaryOrganismProvider(int bitLength) {
        this.bitLength = bitLength;
    }

    @Override
    public BinaryOrganism randOrganism(int timeOfCreation, int orgID, Random rand) {
        return new BinaryOrganism(genRandomChromosome(bitLength, rand), timeOfCreation, orgID) ;
    }

    private String genRandomChromosome(int bitLength, Random rand) {
        String chromosome = "";
        for(int i = 0; i < bitLength; i++) {
            if(rand.nextBoolean()) chromosome += '1'; else chromosome += '0';
        }
        return chromosome;
    }
}
