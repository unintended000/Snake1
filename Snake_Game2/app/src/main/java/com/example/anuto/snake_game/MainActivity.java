package com.example.anuto.snake_game;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.anuto.snake_game.Class_game.cGame;
import com.example.anuto.snake_game.NN.GA.GA.cGA;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


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


    }
    public void Click(View view) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        cGA GA = new cGA(3,list,2);
        int[] k= {3,2,4};
        GA.setPrice( k);
        GA.Learning();
    }

}
