package net.berlitz.selection;

import net.berlitz.populationBuilders.BinaryOrganism;
import net.berlitz.populationBuilders.Population;

import java.util.*;

public class BinaryTournamentSelection {
    public static BinaryOrganism selection(Population population, int tournamentSize) {
        Random rand = population.rand;
        HashMap<Integer, BinaryOrganism> organisms = population.getWholePop();
        List<Integer> keys = new ArrayList<>(organisms.keySet());

        // Select random individuals for the tournament
        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = rand.nextInt(keys.size());
            selected.add(keys.get(randomIndex));
        }

        // Find the best individual in the tournament
        Integer bestKey = selected.stream()
                .max(Comparator.comparing(key -> organisms.get(key).getFitness()))
                .orElseThrow(() -> new IllegalArgumentException("Tournament selection failed"));

        return organisms.get(bestKey);  // Return the best BinaryOrganism
    }
}
