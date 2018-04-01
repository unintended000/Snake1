package com.example.anuto.snake_game;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.anuto.snake_game.Class_game.cGame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {
public String FILENAME="Field.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            File file = new File(this.getFilesDir(), FILENAME);
            OutputStream os= openFileOutput(FILENAME, Context.MODE_PRIVATE);
            //Перезаписываем фданные с файла из ресурсов в фаил из памяти (начальные закладки)
            InputStream is = getAssets().open("1.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            os.write(buffer);
            os.close();
            is.close();
            //Вызываем еще раз


        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public void NewGame_Click(View view) {
        startActivity(new Intent(this, GameLayoutActivity.class));

        cGame Game= new cGame(this);
    }
}
