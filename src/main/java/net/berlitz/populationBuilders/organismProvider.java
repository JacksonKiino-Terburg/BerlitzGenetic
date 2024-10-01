package net.berlitz.populationBuilders;

import java.util.Random;

public interface organismProvider {
    public Organism randOrganism(int timeOfCreation, int orgID);
}
