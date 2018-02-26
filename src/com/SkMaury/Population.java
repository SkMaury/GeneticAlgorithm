package com.SkMaury;

public class Population {

    private Individual[] individuals;

    public Population(int populationSize) {
        individuals = new Individual[populationSize];
    }

    public void initialize(){
        for(int i = 0; i < individuals.length; i++){
            Individual newIndividual = new Individual();
            newIndividual.generateIndividual();
            saveIndividual(i, newIndividual);
        }
    }

    public void saveIndividual(int index, Individual individual) {
        this.individuals[index] = individual;
    }

    public Individual getIndividuals(int index) {
        return individuals[index];
    }

    public Individual getFittestIndividual(){
        Individual fittest = individuals[0];
        for(int i = 1; i < individuals.length; i++){
            if(getIndividuals(i).getFitness() >= fittest.getFitness()){
                fittest = getIndividuals(i);
            }
        }
        return fittest;
    }

    public int size(){
        return this.individuals.length;
    }
}
