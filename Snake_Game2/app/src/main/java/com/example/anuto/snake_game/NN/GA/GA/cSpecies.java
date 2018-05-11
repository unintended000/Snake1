package com.example.anuto.snake_game.NN.GA.GA;

import java.util.ArrayList;
import java.util.Random;

public class cSpecies {
    public void setPrice(int price) {
        Price = price;
    }

    public int getPrice() {
        return Price;
    }

    private int Price;
    public ArrayList<cGene> Genes;


    Random rnd = new Random();
    public cSpecies() {
        Genes = new ArrayList<>();
        Price=0;
    }

    cSpecies New_Species(ArrayList<Integer> countLayer){
        cSpecies Species = new cSpecies();

        for (int i=0;i<countLayer.size()-1;i++){
            cGene Gene = new cGene(countLayer.get(i),countLayer.get(i+1));
            Gene.NewGene(countLayer.get(i),countLayer.get(i+1));
            Genes.add(Gene);
        }
        return Species;
    }

    cSpecies Mutation (cSpecies species){
        int i,j;
        for (int k=0;k<species.Genes.size();k++){
             i = rnd.nextInt(species.Genes.get(k).Gene.length);
             j=rnd.nextInt(species.Genes.get(k).Gene[0].length);
            float r=rnd.nextInt(100);
            species.Genes.get(k).Gene[i][j]= r/100;

        }

     return species;
    }

}
