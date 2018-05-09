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
    public Draw_Snake(Context context, cSnake Snake) {
        super(context);
        mSnake = Snake;

    }

    private Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.rgb(255,127,0));
        for (int Count = 0; mSnake.SnakeList.size()> Count; Count++) {
            canvas.drawRect( mSnake.SnakeList.get(Count).CoordX*53, mSnake.SnakeList.get(Count).CoordY*53,
                             mSnake.SnakeList.get(Count).CoordX*53+60,  mSnake.SnakeList.get(Count).CoordY*53+60,mPaint);
        }

    }
}
