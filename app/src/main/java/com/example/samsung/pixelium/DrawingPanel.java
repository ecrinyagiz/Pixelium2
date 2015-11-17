package com.example.samsung.pixelium;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Samsung on 17.11.2015.
 */
/*
    AN OBJECT OF THIS CLASS WILL BE CREATED WHEN THE USER ENTERS
    CANVAS OF THE APP
    IT WILL PROVIDE SKETCHING WITH DIFFERENT STYLES
 */
public class DrawingPanel extends View {

    protected Canvas canvas;
    protected Path path;
    protected Paint brush,paint;
    protected Bitmap grid;
    protected Button pencil;

    //CONSTRUCTOR
    public DrawingPanel(Context context) {
        super(context); // calls the View constructor

        // initialize the objects necessary for painting the screen
        brush = new Paint();
        paint = new Paint();
        path = new Path();
        canvas = new Canvas();
       // pencil = (Button)findViewById(R.id.pencil);
        /*
        in first calling set the brush with these initial
        conditions on the DrawingPanel
         */
        brush.setAntiAlias(true);
        brush.setColor(Color.BLACK);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(15f);
        paint = new Paint(Paint.DITHER_FLAG);
    }
    public void styleChanges(View v)
    {
        brush.setColor(Color.BLUE);
        brush.setStyle(Paint.Style.FILL);
        brush.setStrokeWidth(20f);
    }

    /*
    This method inherited from View class makes possible to get the areas that user
    touched via storing the points on PATH object
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

        // Checks for the event that occurs
        switch (event.getAction()) {
            // when user starts touching
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);
                return true;
            // still touching, path stores the points
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                break;
            // when user release the screen
            case MotionEvent.ACTION_UP:
                // draw on canvas the points via Paint object brush
                canvas.drawPath(path, brush);
                path.reset(); // reset the stored points on path
                break;
            default:
                return false;
        }
        // After path returns with some point force view to reflect the changing things
        postInvalidate();
        return false;
    } //END OF onTouchEvent
    @Override

    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(grid, 0, 0, paint);
        canvas.drawPath(path, brush);
    }
    // TO SCALE THE SCREEN
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        grid = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(grid);
        draw(canvas);
    }

    public void newFile(){
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        invalidate();
    }

}
