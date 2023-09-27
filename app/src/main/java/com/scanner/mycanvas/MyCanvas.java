package com.scanner.mycanvas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class MyCanvas extends View {

    Rect rect;
    Paint paint;

    float xPos1, yPos1, xPos2, yPos2;

    int point = 1;

    public MyCanvas(Context context) {
        super(context);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect = new Rect(0, 0, 200, 200);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        // canvas.drawRect(rect, paint);
        //canvas.drawCircle(xPos, yPos, 100, paint);

        if (point == 1) {
            canvas.drawCircle(xPos1, yPos1, 100, paint);
            //canvas.drawLine(xPos1, yPos1, xPos2, yPos2, paint);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (point == 1) {
            xPos1 = event.getX();
            yPos1 = event.getY();
            //point = 2;
        } else {
            xPos2 = event.getX();
            yPos2 = event.getY();
            point = 1;
        }

        invalidate();
        return super.onTouchEvent(event);
    }
}
