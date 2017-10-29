package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LinearLayoutActivity extends Activity implements XMLFragment.OnFragmentInteractionListener, PaletteFragment.OnFragmentInteractionListener{
    Fragment verticalFragment, horizontalFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("orientation", "vertical");
        verticalFragment = new XMLFragment();
        verticalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutVertical, verticalFragment);

        bundle = new Bundle();
        bundle.putString("orientation", "horizontal");
        horizontalFragment = new XMLFragment();
        horizontalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutHorizontal, horizontalFragment);

        fragmentTransaction.commit();

        Button clearAllBtn = findViewById(R.id.clearAllBtn);
        clearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((XMLFragment)verticalFragment).removeAllViews();
                ((XMLFragment)horizontalFragment).removeAllViews();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    @Override
    public void onFragmentInteraction(View.OnDragListener dragListener) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
