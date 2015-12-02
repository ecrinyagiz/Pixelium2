package com.example.samsung.pixelium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Samsung on 18.11.2015.
 */
public class DrawingViewPanel extends AppCompatActivity {

    protected DrawingView drawing; // that will be the canvas
    protected Tools[] tools = {(Tools)findViewById(R.id.pencilButton), (Tools) findViewById(R.id.airBrushButton), (Tools) findViewById(R.id.brushButton),
            (Tools) findViewById(R.id.FillerButton)}; // those buttons have the onClick method called "styleChanges"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.canvas);
        drawing = (DrawingView) findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_layout);
    }

    /*
        when user selects one of the tools on the screen then the attributes of the Paint object will
        be changed according to selected item
     */
    public void selectTool(View view)
    {
        int id = view.getId();

        for(int i = 0; i < tools.length; i++)
        {
            if(tools[i].getId() == id)
                drawing.styleChanges(tools[i].getName());
        }
    }

}
