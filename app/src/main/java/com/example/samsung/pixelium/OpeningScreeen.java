package com.example.samsung.pixelium;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class OpeningScreeen extends AppCompatActivity {

    protected Button alarm,lock,page,pre; // buttons in the openingScreen

    /*
    THIS OVERRIDDEN METHOD PROVIDES SAVE THE VIEW OBJECTS ON BUNDLE OBJECT,
    ALSO THE VIEW OBJECTS SEEN IN UI MUST BE FOUND BY ID IN THIS SECTION
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // calls the parent's onCreate method to store view
        super.onCreate(savedInstanceState);
        // make visible UI
        setContentView(R.layout.activity_opening_screeen);
        // they are also come with overriden method
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
            THESE BUTTONS CREATED BY US TO PROVIDE GO TO ANOTHER ACTIVITY
          */
        alarm = (Button) findViewById(R.id.alarm);
        lock = (Button) findViewById(R.id.lockButton);
        pre = (Button) findViewById(R.id.previous);
        page = (Button) findViewById(R.id.canvas);

    }
    /*
       THE BUTTONS DEFINED ABOVE HAVE THE METHOD "GOTO"
       WHEN THEY ARE PRESSED THIS METHOD GONNA BE CALLED
        */
    public void gotoPage (final View view){
        // find which button is pressed and go to another activity
        switch(view.getId()){
            case R.id.alarm: // if the alarm button is selected go to setAlarm
                Intent setAlarm= new Intent(this,setAlarm.class);
                startActivity(setAlarm);
                break;
            case R.id.canvas: // if the canvas button is selected open DRAWINGPANEL
                Intent mycanvas = new Intent(this,DrawingViewPanel.class);
                startActivity(mycanvas);
                break;
            case R.id.previous: // if the preWorks button is selected go to PreviousWorks
                Intent preWorks = new Intent(this,PreviousWorks.class);
                startActivity(preWorks);
                break;
            case R.id.lockButton: // if the lockButton is selected go to ChildLock
                Intent childLock = new Intent(this,ChildLock.class);
                startActivity(childLock);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opening_screeen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
