package com.example.anuto.snake_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import com.example.anuto.snake_game.Class_game.cField;
import com.example.anuto.snake_game.Class_game.cGame;

import java.lang.reflect.Field;

/**
 * Created by anuto on 02.04.2018.
 */

public class Draw extends View {
    private Bitmap mBitmap_grass;
    private Bitmap mBitmap_stone;
    //размеры поля
    private int CountBlockWidth=19;
    private int CountBlockHeight=20;

    cField mField;

    public Draw(Context context,  cField Field) {
        super(context);
         mField=Field;
        Resources res = this.getResources();
        mBitmap_grass = BitmapFactory.decodeResource(res, R.drawable.grass);


        mBitmap_stone = BitmapFactory.decodeResource(res, R.drawable.stone);

    }
    private Paint mPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

      //
       canvas.drawBitmap(mBitmap_stone,0, 0, mPaint);
        canvas.drawBitmap(mBitmap_grass, 60, 0, mPaint);

        int i;
        int j;
        for (int Count=0;mField.Field.size() > Count;Count++ ){

            if (mField.Field.get(Count).type) {

                i = mField.Field.get(Count).CoordX * 30;
                j = mField.Field.get(Count).CoordY * 30;
                canvas.drawBitmap(mBitmap_stone, i, j, mPaint);
            }else{
              /*  i = mField.Field.get(Count).CoordX * 15;
                j = mField.Field.get(Count).CoordY * 15;
                canvas.drawBitmap(mBitmap_grass, i, j, mPaint);*/
            }
        }



    }
}