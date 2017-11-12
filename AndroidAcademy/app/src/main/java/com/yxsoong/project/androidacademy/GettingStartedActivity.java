package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GettingStartedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }

//    public boolean onOptionsItemSelected(MenuItem item){
//        finish();
//        return true;
//    }

    public void onClick_GoToCreateProjectActivity(View view){
        Intent myIntent = new Intent(this, CreateProjectActivity.class);
        startActivity(myIntent);
    }

    public void onClick_GoToAndroidEmulatorActivity(View view){
        Intent myIntent = new Intent(this, AndroidEmulatorActivity.class);
        startActivity(myIntent);
    }
    public void onClick_GoToAndroidManifestActivity(View view){
        Intent myIntent = new Intent(this, AndroidManifestActivity.class);
        startActivity(myIntent);
    }
    public void onClick_GoToWidgetsActivity(View view){
        Intent myIntent = new Intent(this, WidgetsActivity.class);
        startActivity(myIntent);
    }

    public void onClick_GoToTaskActivity(View view){
        Intent myIntent = new Intent(this, GettingStartedTaskActivity.class);
        startActivity(myIntent);
    }
}
