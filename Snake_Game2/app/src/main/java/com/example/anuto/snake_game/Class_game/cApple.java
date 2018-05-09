package com.example.anuto.snake_game.Class_game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by anuto on 20.03.2018.
 */

public class cApple extends cCell {

    cApple(byte xx, byte yy) {
        super(xx, yy);
    }

    cApple NewApple(ArrayList<cCellField> Field){

        cCellField CellField;
        Random rnd=new Random();
        do {
            CellField = Field.get(rnd.nextInt(Field.size()));
        }  while (CellField.type);

        return new cApple(CellField.CoordX,CellField.CoordY);
    }

}
