package com.example.a2monkr41.a2dgraphics;

/**
 * Created by 2monkr41 on 11/04/2018.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;

public class GraphicsView extends View implements View.OnTouchListener
{
    Paint p;
    Bitmap image;

    int counter = 0;
    float curX, curY;

    public GraphicsView (Context ctx)
    {
        super(ctx);

        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(24);
        image = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.hero);

        this.setOnTouchListener(this);
    }

    public void onDraw (Canvas canvas)
    {
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(10, 10, 110, 110, p);
        canvas.drawText("Hello Graphics World!", 0, 200, p);

        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(3);
        canvas.drawRect(10,400,410,800,p);


        canvas.drawBitmap(image ,curX, curY, null);
        counter ++;
        canvas.drawText("Counter is now:" + counter, 0, 300, p);
    }

    public boolean onTouch(View view,MotionEvent ev)
    {
        curX = ev.getX();
        curY = ev.getY();
        postInvalidate();

        return true;
    }
}
