package com.example.anuto.snake_game.Class_game;

import android.content.Context;

import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anuto on 21.03.2018.
 */

public class cGame {

    public int Point;
    public byte Life;
    public cField Field;
    private EDirection m_enDirection;
    private Context context_;
    private Timer Game_Timer;


   public cGame(Context context){
       context_=context;
        Create_field();
        NewGame();
       m_enDirection=EDirection.Left;
       Start_Game();

    }

    //Создание поля
    void Create_field(){
        Field=new cField();
        Field.Load("Field.txt", context_);
    }

    void NewGame()
    {
        Life = 3;
        Point =0;
        Game_Timer=new Timer();
    }

    public void Start_Game(){
        TimerTask TimeTask = new UpdateTimeTask();
        Game_Timer.schedule(TimeTask, 250, 1000);
    }

    //region [Движение]
    public enum EDirection{
        Up,
        Down,
        Left,
        Right

    }

    public void Turn(EDirection Direction){
        m_enDirection=Direction;

    }

    //Проверка на блок или змею
    private boolean Check_block_or_Snake (cCellSnake CheckCellSnake){
          /*  if (Field.Field.contains(new cCellField(CheckCellSnake.CoordX,CheckCellSnake.CoordY,true)))
            {
               return false;

            } else if (Field.Snake.SnakeList.contains(CheckCellSnake))
            {
                return  false;
            } else{
                return true;
            }*/
          return true;

    }

    class UpdateTimeTask extends TimerTask {
        public void run() {
            if (Life==0){
            Point=200;
            } else {
                cCellSnake CellSnake=new cCellSnake(Field.Snake.SnakeList.get(0).CoordX,Field.Snake.SnakeList.get(0).CoordY) ;
                switch (m_enDirection){

                    case Left:
                        CellSnake.CoordX--;
                        break;
                    case Right:
                        CellSnake.CoordX++;
                        break;
                    case Up:
                        CellSnake.CoordY--;
                        break;
                    case Down:
                        CellSnake.CoordY++;
                        break;
                }

                if (Check_block_or_Snake(CellSnake)) {
                    //"Дивгаем голову", в случае если там яблоко не удаляем "хвост"
                    Field.Snake.SnakeList.add(0,CellSnake);

                    if ((CellSnake.CoordX==Field.Apple.CoordX)&(CellSnake.CoordY==Field.Apple.CoordY)){
                        Point+=10;
                        //Новое яблоко
                    } else
                        Field.Snake.SnakeList.remove(Field.Snake.SnakeList.size()-1);
                }

                //Если бортик
                else {
                    //пауза
                    Life--;
                    Create_field();
                    //плей
                }


            }
        }
    }



//endregion
}
