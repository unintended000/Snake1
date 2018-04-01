package com.example.anuto.snake_game.Class_game;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by anuto on 21.03.2018.
 */

public class cField {

    public cApple Apple;
    public cSnake Snake;
    List<cCellField> Field;

    public cField()
    {
        Field = new ArrayList<cCellField>();
        Snake=new cSnake();

    }

    public void Load(String FILENAME, Context context){

        try{

            FileInputStream fIn = context.getApplicationContext().openFileInput(FILENAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fIn));

           // BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String strLine;
            byte y=0;
            while ((strLine = br.readLine()) != null){
                for (byte x =0; x<strLine.length();x++)
                {
                    String Value = strLine.substring(x,x+1);
                    switch (Value)
                    {
                        case "0":
                            cCellField Cell_grass0= new cCellField(x,y, false);
                            Field.add(Cell_grass0);
                            break;
                        case "1":
                            cCellField Cell_wall= new cCellField(x,y, true);
                            Field.add(Cell_wall);
                            break;
                        case "2":
                            cCellSnake Cell_snake=new cCellSnake(x,y);
                            Snake.SnakeList.add(Cell_snake);

                            cCellField Cell_grass2= new cCellField(x,y, false);
                            Field.add(Cell_grass2);
                            break;
                        case "3":
                            Apple = new cApple(x,y);

                            cCellField Cell_grass3= new cCellField(x,y, false);
                            Field.add(Cell_grass3);
                            break;

                    }


                }
                y++;
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }



    }




    ;

}
