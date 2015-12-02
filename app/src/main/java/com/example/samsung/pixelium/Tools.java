package com.example.samsung.pixelium;

import android.content.Context;
import android.view.View;

/**
 * Created by Samsung on 18.11.2015.
 */
public abstract class Tools extends View {

    private int color;
    private int strokeWidth;
    private int strokeJoin;
    private int strokeCap;
    private int style;
    private String name;

    public Tools(Context context)
    {
        super(context);

    }
    public Tools(Context context,String name)
    {
        super(context);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getColor()
    {
        return color;
    }
    public int getStrokeWidth()
    {
        return strokeWidth;
    }
}
