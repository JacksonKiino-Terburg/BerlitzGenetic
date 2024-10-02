package net.berlitz;

import net.berlitz.crossover.BinarySinglePointCrossover;
import net.berlitz.functions.examples.Quadratic;
import net.berlitz.mutators.BinaryMutator;
import net.berlitz.populationBuilders.BinaryOrganism;
import net.berlitz.populationBuilders.BinaryOrganismProvider;
import net.berlitz.populationBuilders.Population;
import net.berlitz.selection.BinaryTournamentSelection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class BinaryGADriver {
    public static void run(int numGens, int chromosomeSize, int populationSize, int tournamentSize, float mutationRate, float crossoverRate, boolean Maximize, int[] funcParams) {
        Population population = new Population(populationSize, mutationRate, crossoverRate, new BinaryOrganismProvider(chromosomeSize));
        System.out.println(population.getWholePop());
        ArrayList<Long> bestFitVals = new ArrayList<>();
        Quadratic function = new Quadratic(funcParams[0], funcParams[1], funcParams[2]);

        for(int generation : IntStream.rangeClosed(0, numGens - 1).toArray()) {
            //set fitnesses
            population.getWholePop().forEach((id, organism) -> {
                if(Maximize) {organism.setFitness(function.fitnessMaximize(Integer.parseInt((String) organism.Chromosome, 2))); }
                else { organism.setFitness(function.fitnessMinimize(Integer.parseInt((String) organism.Chromosome, 2))); }
            });

            population.getWholePop().forEach((id, organism) -> {
                BinaryOrganism org1 = BinaryTournamentSelection.selection(population, tournamentSize);
                BinaryOrganism org2 = BinaryTournamentSelection.selection(population, tournamentSize);

                //crossover
                if(population.rand.nextFloat() <= crossoverRate) {
                    BinaryOrganism[] crossoverResult = BinarySinglePointCrossover.crossover(population, org1, org2);
                    org1 = crossoverResult[0];
                    org2 = crossoverResult[1];
                }
                //mutation
                if(population.rand.nextFloat() <= mutationRate) { org1 = BinaryMutator.mutate(population, org1); }
                if(population.rand.nextFloat() <= mutationRate) { org2 = BinaryMutator.mutate(population, org2); }
            });
            bestFitVals.add(0, getHighestPerformer(population));
        }
        System.out.println("Best fitness: " + bestFitVals.get(0));
    }

    private static Long getHighestPerformer(Population population) {
        return population.getWholePop().values().stream()
                .max(Comparator.comparingLong(BinaryOrganism::getFitness))
                .orElseThrow(() -> new IllegalArgumentException("Population is empty")).getFitness();
    }
}
