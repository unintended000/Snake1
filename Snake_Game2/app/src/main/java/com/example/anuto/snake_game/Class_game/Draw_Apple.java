package com.example.anuto.snake_game.Class_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.anuto.snake_game.R;

/**
 * Created by anuto on 02.04.2018.
 */
public class Draw_Apple extends View {
   // private Bitmap mBitmap_grass;


    cApple mApple;

    public Draw_Apple(Context context, cApple Apple) {
        super(context);
        mApple = Apple;

    }

    private Paint mPaint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mPaint.setColor(Color.RED);
        canvas.drawRect(mApple.CoordX*53,mApple.CoordY*53,
             mApple.CoordX*53+60,mApple.CoordY*53+60,mPaint);

    }
}
