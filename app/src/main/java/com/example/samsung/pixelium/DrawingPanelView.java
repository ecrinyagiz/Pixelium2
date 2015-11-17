package com.example.samsung.pixelium;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Samsung on 17.11.2015.
 */

/* This class gonna call when the user press CANVAS button
    It will create an object from the DrawingPanel
 */
public class DrawingPanelView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawingPanel view = new DrawingPanel(this); // we passed this class to DrawingPanel
        setContentView(view);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}