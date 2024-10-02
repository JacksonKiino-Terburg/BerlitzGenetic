package net.berlitz;

import net.berlitz.crossover.BinarySinglePointCrossover;
import net.berlitz.functions.examples.Quadratic;
import net.berlitz.mutators.BinaryMutator;
import net.berlitz.populationBuilders.BinaryOrganism;
import net.berlitz.populationBuilders.BinaryOrganismProvider;
import net.berlitz.populationBuilders.Population;
import net.berlitz.selection.BinaryTournamentSelection;
import net.berlitz.util.BinaryConverter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

public class BinaryGADriver {
    public static void run(int numGens, int chromosomeSize, int populationSize, int tournamentSize, float mutationRate, float crossoverRate, boolean Maximize, int[] funcParams) {
        Population population = new Population(populationSize, mutationRate, crossoverRate, new BinaryOrganismProvider(chromosomeSize));
        System.out.println(population.getWholePop());
        ArrayList<Long> bestFitVals = new ArrayList<>();
        Quadratic function = new Quadratic(funcParams[0], funcParams[1], funcParams[2]);
        HashMap<Integer, BinaryOrganism> newPopulation = new HashMap<>();

        for(int generation : IntStream.rangeClosed(0, numGens - 1).toArray()) {
            population.printPopulation();
            //set fitnesses
            population.getWholePop().forEach((id, organism) -> {
                if(Maximize) {organism.setFitness(function.fitnessMaximize(BinaryConverter.binToDec((String) organism.Chromosome))); }
                else { organism.setFitness(function.fitnessMinimize(BinaryConverter.binToDec((String) organism.Chromosome))); }
            });
            //clear new pop
            newPopulation.clear();
            while(newPopulation.size() < populationSize) {
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

                newPopulation.put(org1.id, org1);
                newPopulation.put(org2.id, org2);
            }
            population.setPopulation(newPopulation);
            bestFitVals.add(getHighestPerformer(population));
            System.out.println("Current Gen " + generation);
            System.out.println("Best fitness: " + bestFitVals.get(bestFitVals.size()-1));
        }
    }

    private static Long getHighestPerformer(Population population) {
        return population.getWholePop().values().stream()
                .min(Comparator.comparingLong(BinaryOrganism::getFitness))
                .orElseThrow(() -> new IllegalArgumentException("Population is empty")).getFitness();
    }
}
