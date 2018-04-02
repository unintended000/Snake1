package com.example.anuto.snake_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.anuto.snake_game.Class_game.cField;

/**
 * Created by anuto on 02.04.2018.
 */

public class Draw extends View {
    private Bitmap mBitmap_grass;
    private Bitmap mBitmap_stone;
    private  Bitmap mBitmap_snake;
    private Bitmap mBitmap_apple;
    cField mField;
    enWhatDraw mWhatDraw;

    enum enWhatDraw {
        FieldDraw,
        Apple,
        Snake

    }

    public Draw(Context context,  cField Field, enWhatDraw WhatDraw) {
        super(context);
         mField=Field;
         mWhatDraw =WhatDraw;

        Resources res = this.getResources();
        switch (mWhatDraw) {
            case FieldDraw:
                mBitmap_grass = BitmapFactory.decodeResource(res, R.drawable.grass);
                mBitmap_stone = BitmapFactory.decodeResource(res, R.drawable.stone);
                break;
            case Snake:
                mBitmap_snake = BitmapFactory.decodeResource(res, R.drawable.snakeskin1);
                break;
            case Apple:
                break;



        }


        }

    private Paint mPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        switch (mWhatDraw) {

            //region [Рисуем поле]
            case FieldDraw: {
                int i;
                int j;

                for (int Count = 0; mField.Field.size() > Count; Count++) {

                    if (mField.Field.get(Count).type) {

                        i = mField.Field.get(Count).CoordX * 40;
                        j = mField.Field.get(Count).CoordY * 40;
                        canvas.drawBitmap(mBitmap_stone, i, j, mPaint);
                    } else {
                        i = mField.Field.get(Count).CoordX * 40;
                        j = mField.Field.get(Count).CoordY * 40;
                        canvas.drawBitmap(mBitmap_grass, i, j, mPaint);
                    }

                }
                break;
            }
            //endregion

            //region [Рисуем змею]
            case Snake:
                int i;
                int j;
                for (int Count = 0; mField.Snake.SnakeList.size()> Count; Count++) {

                        i = mField.Snake.SnakeList.get(Count).CoordX * 40;
                        j = mField.Snake.SnakeList.get(Count).CoordY * 40;
                        canvas.drawBitmap(mBitmap_snake, i, j, mPaint);
                    }
                break;
            //endregion

            //region [Рисуем яблоко]
            case Apple:
                break;
            //endregion
        }

        }



    }


