package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity implements MainViewFragment.OnFragmentInteractionListener{

    Button lesson1Btn, lesson2Btn, lesson3Btn, lesson4Btn, testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        MainViewFragment mainFragment = new MainViewFragment();
        fragmentTransaction.add(R.id.mainLayout1, mainFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void switchActivity(String activity) {
        Intent myIntent = null;
        if(activity.equals("GettingStartedActivity")){
            myIntent = new Intent(this, GettingStartedActivity.class);
        } else if(activity.equals("Lesson1Activity")) {
            myIntent = new Intent(this, Lesson1Activity.class);
        }
        if(myIntent != null)
            startActivity(myIntent);
    }
}
