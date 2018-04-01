package com.example.anuto.snake_game.Class_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by anuto on 02.04.2018.
 */

public class Draw extends View {
    public Draw(Context context) {
        super(context);
    }
    private Paint mPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(canvas.getWidth() - 30, 30, 25, mPaint);


    }
}