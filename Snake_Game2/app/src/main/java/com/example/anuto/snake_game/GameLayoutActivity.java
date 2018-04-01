package com.example.anuto.snake_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anuto.snake_game.Class_game.cGame;

import java.util.Timer;
import java.util.TimerTask;


public class GameLayoutActivity extends AppCompatActivity {


    private Timer Game_Timer;
    private cGame Game;
  public  TextView Text ;
    private cGame.EDirection LastKey= cGame.EDirection.Left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
       // cGame Game= new cGame(this);
        //Game_Timer=new Timer();
       // TimerTask TimeTask = new UpdateTime();
       // Game_Timer.schedule(TimeTask, 0, 50);
        Toast.makeText(getApplicationContext(), "куксики", Toast.LENGTH_LONG).show();
Text= (TextView) findViewById(R.id.textView);
    }

  /*  class UpdateTime extends TimerTask {
        public void run() {
            TextView Text = (TextView) findViewById(R.id.textView);
            Text.setText("Голова : "+Game.Field.Snake.SnakeList.get(0).CoordX +"  "+ Game.Field.Snake.SnakeList.get(0).CoordY);

        }
    }

*/
   public void Down_click(View view) {

       if (LastKey!= cGame.EDirection.Up){
            LastKey= cGame.EDirection.Down;
            Game.Turn(LastKey);
            Toast.makeText(getApplicationContext(), "Вниз", Toast.LENGTH_LONG).show();
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
            Toast.makeText(getApplicationContext(), "Влево", Toast.LENGTH_LONG).show();
        }
    }

    public void Right_click(View view) {
        if (LastKey!= cGame.EDirection.Left){
            LastKey = cGame.EDirection.Right;
            Game.Turn(LastKey);
            Toast.makeText(getApplicationContext(), "Вправо", Toast.LENGTH_LONG).show();
        }
    }
    }
