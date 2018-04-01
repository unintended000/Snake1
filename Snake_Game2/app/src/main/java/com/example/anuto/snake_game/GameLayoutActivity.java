package com.example.anuto.snake_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuto.snake_game.Class_game.Draw;
import com.example.anuto.snake_game.Class_game.cGame;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;


public class GameLayoutActivity extends AppCompatActivity {


    private Timer Game_Timer;
    private cGame Game;
    public TextView  Text1;
    int a;
    private cGame.EDirection LastKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        Game= new cGame(this);

        LastKey= cGame.EDirection.Left;
        Game.Turn(LastKey);

        a=0;
        Text1 = (TextView) findViewById(R.id.textView);
      Game_Timer=new Timer();
        TimerTask TimeTask = new UpdateTime();
        Game_Timer.schedule(TimeTask,0, 50);

        ConstraintLayout Layout = (ConstraintLayout) findViewById(R.id.Field_layout) ;
        Draw draw = new Draw(this);
        Layout.addView(draw);


    }

    public void But_click(View view) {
        Text1.setText(""+a);


    }

    private class UpdateTime extends TimerTask {

        @Override
        public void run() {
            GameLayoutActivity.this.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                 //  Text1.setText("Голова "+Game.Field.Snake.SnakeList.get(0).CoordX+"  "+Game.Field.Snake.SnakeList.get(0).CoordY+"   Длина"+Game.Field.Snake.SnakeList.size() );





                }
            });


        }
    }

    public class Draw2D extends View{
        public Draw2D(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
        }
    }


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
    }
