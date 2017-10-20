package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Lesson1Activity extends Activity implements XMLFragment.OnFragmentInteractionListener, PaletteFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment xmlFragment = new XMLFragment();
        fragmentTransaction.add(R.id.xmlFrameLayout, xmlFragment);
        fragmentTransaction.commit();

    }

    public void onClick_BackToPreviousActivity(View view){
        finish();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onFragmentInteraction(View.OnDragListener dragListener) {

    }
}
