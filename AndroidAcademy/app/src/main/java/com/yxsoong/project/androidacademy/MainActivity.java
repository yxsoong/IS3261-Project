package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager =	getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction =	fragmentManager.beginTransaction();
        MainViewFragment mainFragment	=	new MainViewFragment();
        fragmentTransaction.add(R.id.mainLayout1,	mainFragment);
        fragmentTransaction.commit();
    }
}
