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
public class Draw_Field extends View {
    private Bitmap mBitmap_grass;

   cField mField;

    public Draw_Field(Context context, cField Field) {
        super(context);
        mField = Field;

           /** Resources res = this.getResources();
            *
            * mBitmap_grass = BitmapFactory.decodeResource(res, R.drawable.grass);
            * mBitmap_stone = BitmapFactory.decodeResource(res, R.drawable.stone);
            */
        }

        private Paint mPaint = new Paint();

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawRGB(60, 90, 40);
            mPaint.setColor(Color.rgb(29,16,24));

            for (int Count = 0; mField.Field.size() > Count; Count++) {
                if (mField.Field.get(Count).type) {
                    canvas.drawRect(mField.Field.get(Count).CoordX*53,mField.Field.get(Count).CoordY*53,
                                    mField.Field.get(Count).CoordX*53+60, mField.Field.get(Count).CoordY*53+60,mPaint);

                }
            }

    }

}
