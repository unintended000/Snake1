package com.example.anuto.snake_game;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anuto.snake_game.Class_game.Draw_Apple;
import com.example.anuto.snake_game.Class_game.Draw_Field;
import com.example.anuto.snake_game.Class_game.Draw_Snake;
import com.example.anuto.snake_game.Class_game.cGame;

import java.util.Timer;
import java.util.TimerTask;


public class GameLayoutActivity extends AppCompatActivity {


    private Timer Game_Timer;
    private cGame Game;
    private TextView  Text1;
    private TextView  Text2;

    private cGame.EDirection LastKey;
    private ConstraintLayout Field_layout;
    private ConstraintLayout Snake_layout;
    private ConstraintLayout Apple_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        //region FindById
        Field_layout = (ConstraintLayout) findViewById(R.id.Field_layout) ;
        Snake_layout = (ConstraintLayout) findViewById(R.id.Snake_layout) ;
        Apple_layout = (ConstraintLayout) findViewById(R.id.Apple_layout) ;

        Text1=(TextView)findViewById(R.id.textView);
        Text2=(TextView)findViewById(R.id.textView2);
        //endregion



        Game_Timer=new Timer();
        TimerTask TimeTask = new UpdateTime();
        Game_Timer.schedule(TimeTask,0, 50);


        Game= new cGame(this);
        LastKey= cGame.EDirection.Left;
        Game.Turn(LastKey);

        Paint_Field();
        Paint_Snake();
        Paint_Apple();


    }

    private class UpdateTime extends TimerTask {

        @Override
        public void run() {
            GameLayoutActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    Paint_Snake();
                    Paint_Apple();
                    Text1.setText("Змея "+Game.Field.Snake.SnakeList.size()+"   " + Game.Field.Snake.SnakeList.get(0).CoordX+","+Game.Field.Snake.SnakeList.get(0).CoordY);
                    Text2.setText("Яблоко "+Game.Field.Apple.CoordX+","+Game.Field.Apple.CoordY+ "  Очки "+Game.Point+ "  Жизнь "+Game.Life);

                }
            });
        }
    }


   //region Рисование
    private void Paint_Snake(){
        Snake_layout.removeAllViews();
        Draw_Snake drawSnake= new Draw_Snake(GameLayoutActivity.this, Game.Field.Snake);
        Snake_layout.addView(drawSnake);

    }

    public void Paint_Apple(){
        Apple_layout.removeAllViews();
        Draw_Apple drawApple=new Draw_Apple(GameLayoutActivity.this, Game.Field.Apple);
        Apple_layout.addView(drawApple);
    }

    private void Paint_Field(){
        Draw_Field drawField = new Draw_Field(this, Game.Field);
        Field_layout.addView(drawField);
    }
    //endregion


   // region Кнопки
    public void Down_click(View view) {
       if (LastKey!= cGame.EDirection.Up){
            LastKey= cGame.EDirection.Down;
            Game.Turn(LastKey);
        }
    }

    public void Up_click(View view) {
        if (LastKey!= cGame.EDirection.Down){
            LastKey = cGame.EDirection.Up;
            Game.Turn(LastKey);
        }
    }

    public void Left_click(View view) {
        if (LastKey!= cGame.EDirection.Right){
            LastKey = cGame.EDirection.Left;
            Game.Turn(LastKey);
        }
    }

    public void Right_click(View view) {
        if (LastKey!= cGame.EDirection.Left){
            LastKey = cGame.EDirection.Right;
            Game.Turn(LastKey);
        }
    }
    //endregion

    }
