package com.example.anuto.snake_game.Class_game;

/**
 * Created by anuto on 21.03.2018.
 */

public class cCellField extends  cCell {

    public boolean type;

    cCellField(byte xx, byte yy, boolean type1){
        super(xx,yy);
        type=type1;

    }
}
