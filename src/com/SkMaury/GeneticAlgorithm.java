package com.SkMaury;

import java.util.Random;

public class GeneticAlgorithm {

    private Random randomGenerator;

    public GeneticAlgorithm() {
        this.randomGenerator = new Random();
    }

    public Population evolvePopulation(Population population){
        Population newPopulation = new Population(population.size());

        for(int i = 0; i < population.size(); ++i){
            Individual firstIndividual = randomSelection(population);
            Individual secondIndividual = randomSelection(population);
            Individual newIndividual = crossover(firstIndividual, secondIndividual);
            newPopulation.saveIndividual(i, newIndividual);
        }
        for(int i = 0; i < newPopulation.size(); ++i){
            mutate(newPopulation.getIndividuals(i));
        }
        return newPopulation;
    }

    private void mutate(Individual individual) {
        for(int i = 0; i < Constants.CHROMOSOME_LENGTH; ++i){
            if(Math.random() <= Constants.MUTATION_RATE){
                int gene = randomGenerator.nextInt(Constants.CHROMOSOME_LENGTH);
                individual.setGene(i, gene);
            }
        }
    }

    private Individual crossover(Individual firstIndividual, Individual secondIndividual) {

        Individual newSolution = new Individual();
        for(int i = 0; i < Constants.CHROMOSOME_LENGTH; ++i){
            if(Math.random() <= Constants.CROSSOVER_RATE){
                newSolution.setGene(i, firstIndividual.getGene(i));
            }
            else{
                newSolution.setGene(i, secondIndividual.getGene(i));
            }
        }
        return newSolution;
    }

    private Individual randomSelection(Population population) {

        Population newPopulation = new Population(Constants.TOURNAMENT_SIZE);

        for(int i = 0; i < Constants.TOURNAMENT_SIZE; ++i){
            int randomIndex = (int)(Math.random() * population.size());
            newPopulation.saveIndividual(i, population.getIndividuals(randomIndex));
        }
        Individual fittestIndividual = newPopulation.getFittestIndividual();
        return fittestIndividual;
    }
}
