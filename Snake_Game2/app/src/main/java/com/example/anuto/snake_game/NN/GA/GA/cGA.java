package com.example.anuto.snake_game.NN.GA.GA;

import java.util.ArrayList;
import java.util.Random;

public class cGA {

    public cSpecies[] Population;
    private cSpecies[] Parent;
    public int[] Max;
    public int[] Average;
    public int _Average;
    private Random rnd;

    public cGA(  int _Species,  ArrayList<Integer> _countLayer, int _Parent) {
        rnd= new Random();

        Population = new cSpecies[_Species];
        cSpecies newSpecies;

        for (int i=0;i<Population.length;i++){
            newSpecies = new cSpecies();
            newSpecies.New_Species(_countLayer);
            Population[i]=newSpecies;
        }

        Parent = new cSpecies[_Parent];

    }

    public void setPrice(int[] _Price){
        for (int i=0; i<Population.length;i++)
            Population[i].setPrice(_Price[i]);

    }

    //region [Скрещивание]

    //Сортировка
    private void Sort (cSpecies[] Population){
        cSpecies Species;
        for (int i = 0; i < Population.length - 1; i++)
          for (int j = 0; j < Population.length - 1; j++)
                if (Population[j].getPrice() < Population[j + 1].getPrice()) {
                    Species = Population[j];
                    Population[j] = Population[j + 1];
                    Population[j + 1]= Species;
                }
    }

    //Получить массив родителей
    private void Get_parents (){
        Sort(Population);
        System.arraycopy(Population, 0, Parent, 0, Parent.length);
    }

    //Скрещивание
    private cSpecies Crossing (cSpecies Parent1, cSpecies Parent2){

        for (int k = 0; k< Parent1.Genes.size(); k++)
            for (int i = 0; i< Parent1.Genes.get(k).Gene.length; i++)
                Parent1.Genes.get(k).Gene[i]= (i%2==0)? Parent2.Genes.get(k).Gene[i]: Parent1.Genes.get(k).Gene[i];

        return (rnd.nextInt(100)<20)? Parent1.Mutation(Parent1):Parent1;

    }

    //Обучение
    public void Learning(){
        Get_parents();
        _Average=0;

        cSpecies Parent1, Parent2;
        cSpecies[] NewPopulation = new cSpecies[Population.length];

        for (int i=0; i<NewPopulation.length;i++) {
            do {
                Parent1 = Parent[rnd.nextInt(Parent.length)];
                Parent2 = Parent[rnd.nextInt(Parent.length)];
            } while (Parent1.equals(Parent2));

            NewPopulation[i]=  Crossing(Parent1, Parent2);
        }
    }

    //endregion
}
