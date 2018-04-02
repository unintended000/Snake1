package com.example.anuto.snake_game.Class_game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.anuto.snake_game.R;

/**
 * Created by anuto on 02.04.2018.
 */
public class Draw_Field extends View {
    private Bitmap mBitmap_grass;
    private Bitmap mBitmap_stone;

    cField mField;

    public Draw_Field(Context context, cField Field) {
        super(context);


            mField = Field;
            Resources res = this.getResources();

            mBitmap_grass = BitmapFactory.decodeResource(res, R.drawable.grass);
            mBitmap_stone = BitmapFactory.decodeResource(res, R.drawable.stone);

        }

        private Paint mPaint = new Paint();

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

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

    }
}
