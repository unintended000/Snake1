package com.example.anuto.snake_game.Class_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

import com.example.anuto.snake_game.R;


  public  class Draw_Snake extends View {

    cSnake mSnake;
    Bitmap mBitmap_snake;
    public Draw_Snake(Context context, cSnake Snake) {
        super(context);
        mSnake = Snake;
        Resources res = this.getResources();

        mBitmap_snake = BitmapFactory.decodeResource(res, R.drawable.snakeskin1);
    }

    private Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




        int i;
        int j;

        for (int Count = 0; mSnake.SnakeList.size()> Count; Count++) {

            i = mSnake.SnakeList.get(Count).CoordX * 40;
            j = mSnake.SnakeList.get(Count).CoordY * 40;
            canvas.drawBitmap(mBitmap_snake, i, j, mPaint);
        }

    }
}
