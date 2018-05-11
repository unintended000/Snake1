package com.example.anuto.snake_game.NN.GA.GA;

import java.util.Random;

public class cGene {
    public float[][] Gene;
    Random rnd;

    public cGene(int i, int j) {
        Gene = new float[i][j];
    }

    void NewGene (int _i, int _j){
         rnd = new Random();
        for (int i=0;i<_i;i++)
            for (int j=0;j<_j;j++){
            float r=rnd.nextInt(100);
            Gene[i][j]=r/100;
        }
    }

}
