package com.SkMaury;

public class Main {
    public static void main(String args[]){
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();

        Population population = new Population(100);
        population.initialize();

        int generationCounter = 0;

        while(population.getFittestIndividual().getFitness() != Constants.MAX_FITNESS){
            ++generationCounter;
            System.out.println("Generation " + generationCounter + " Fittest is -> " + population.getFittestIndividual().getFitness());
            System.out.println(population.getFittestIndividual() + "\n");
            population = geneticAlgorithm.evolvePopulation(population);
        }
        System.out.println("\n\nSolution Acquired");
        System.out.println(population.getFittestIndividual());
    }
}
