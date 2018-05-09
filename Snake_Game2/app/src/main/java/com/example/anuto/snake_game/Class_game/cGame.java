package com.example.anuto.snake_game.Class_game;

import android.content.Context;

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

    // Создание поля
    private void Create_field(){
        Field=new cField();
        Field.Load(context_);
    }

    //region [Игра]
    private void NewGame()
    {
        Life = 3;
        Point =0;

    }


    private void Start_Game(){
        Game_Timer=new Timer();
        TimerTask TimeTask = new UpdateTimeTask();

        Game_Timer.schedule(TimeTask, 100, 300);
    }

    private void End_Game(){
        Game_Timer.cancel();
    }

    //endregion


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
    private boolean Check_block_or_Snake (cCellSnake CheckCellSnake) {
        cCellField CellField1 = Field.Field.stream().filter(x -> (x.CoordX == CheckCellSnake.CoordX) & (x.CoordY == CheckCellSnake.CoordY)).findFirst().get();

        return !CellField1.type && !Field.Snake.SnakeList.contains(CheckCellSnake);


    }

    class UpdateTimeTask extends TimerTask {
        public void run() {
            /*if (Life==0){
            Point=200;
            } else */{
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
                        Field.GetApple();
                    } else
                        Field.Snake.SnakeList.remove(Field.Snake.SnakeList.size()-1);
                }

                //Если бортик
                else {
                    End_Game();
                    Life--;
                    Create_field();
                    Start_Game();
                }


            }
        }
    }



//endregion
}
