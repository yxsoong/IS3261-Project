package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class Lesson1Activity extends Activity {
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /*FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment xmlFragment = new XMLFragment();
        fragmentTransaction.add(R.id.xmlFrameLayout, xmlFragment);
        fragmentTransaction.commit();

        linearLayout = findViewById(R.id.lesson1LinearLayout);
        linearLayout.setOnDragListener(dragListener);*/
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    public void onClick_GoToLinearLayoutActivity(View view){
        Intent myIntent = new Intent(this, LinearLayoutTryMeActivity.class);
        startActivity(myIntent);
    }

    public void onClick_GoToLayoutIntroduction(View view){
        Intent myIntent = new Intent(this, LayoutIntroduction.class);
        startActivity(myIntent);
    }

    public void onClick_GoToLesson1TaskActivity(View view){
        Intent myIntent = new Intent(this, Lesson1TaskActivity.class);
        startActivity(myIntent);
    }

    /*View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    int viewId = event.getClipData().getItemAt(0).getIntent().getIntExtra("viewId",-1);
                    String viewType = event.getClipData().getItemAt(0).getIntent().getStringExtra("viewType");

                    XMLFragment xmlFragment1 = (XMLFragment) getFragmentManager().findFragmentById(R.id.xmlFrameLayout);
                    xmlFragment1.removeViews(viewId, viewType);
                    break;

            }
            return true;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onFragmentInteraction(View.OnDragListener dragListener) {

    }*/
}
