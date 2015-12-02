package com.example.samsung.pixelium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Samsung on 18.11.2015.
 */
/*
    This class extended from View is gonna be used as
    canvas where user can draw something on it.
 */
public class DrawingView extends View {

    // the necessary classes in Android for drawing by touch
    protected Canvas canvas;
    protected Bitmap grid;
    protected Paint brush, canvasPaint;
    protected Path path;
    protected int paintColor = 0xFF550000;
    protected float brushSize = 10f;
    protected Tools[] tools = {new Pencil(getContext(),"PENCIL"), new Brush(getContext(),"BRUSH"), new AirBrush(getContext(),"AIRBRUSH"),
            new Filler(getContext(),"FILLER")};
    //CONSTRUCTOR

    public DrawingView(Context context) {
        super(context);
        setupDrawing();
    }

    /*
        this method initializes the necessary components and set default
        drawing tool with initial conditions
     */
    private void setupDrawing() {
        path = new Path();
        brush = new Paint();
        brush.setColor(paintColor);
        brush.setAntiAlias(true);
        brush.setStrokeWidth(brushSize);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeCap(Paint.Cap.ROUND);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw view
        canvas.drawBitmap(grid, 0, 0, canvasPaint);
        canvas.drawPath(path, brush);
    }

    /*
    THIS METHOD IS VERY CRUCIAL SINCE IT ENABLES US TO
    STORE THE POINTS THAT USER TOUCHES, IT STORES ON PATH OBJECT
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //detect user touch
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            // take the point touched
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            // store the points
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            // draw the points via Paint object and reset the path
            case MotionEvent.ACTION_UP:
                canvas.drawPath(path, brush);
                path.reset();
                break;
            default:
                return false;
        }
        // force the view to draw
        invalidate();
        return true;
    }
    public void styleChanges(String str) {
        for (int i = 0; i < tools.length; i++)
            if (tools[i].getName() == str)
                changeTo(tools[i].getColor(), tools[i].getStrokeWidth(),brush);

    }
    private void changeTo(int color, int strokeWidth,Paint paint )
    {
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
    }

}