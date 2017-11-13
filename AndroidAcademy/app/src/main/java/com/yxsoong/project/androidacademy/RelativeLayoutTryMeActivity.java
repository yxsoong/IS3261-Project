package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RelativeLayoutTryMeActivity extends AppCompatActivity implements XMLFragment.OnFragmentInteractionListener, PaletteFragment.OnFragmentInteractionListener{
    private static String ORIENTAION_KEY = "orientation";
    private static String LAYOUT_KEY = "layoutType";
    Fragment bottomFragment, rightFragment, paletteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_try_me);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString(LAYOUT_KEY, "relativeLayout");
        bundle.putString("orientation", "bottom");
        bottomFragment = new XMLFragment();
        bottomFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutBottom, bottomFragment);

        bundle = new Bundle();
        bundle.putString(LAYOUT_KEY, "relativeLayout");
        bundle.putString(ORIENTAION_KEY, "right");
        rightFragment = new XMLFragment();
        rightFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutRight, rightFragment);

        paletteFragment = new PaletteFragment();
        fragmentTransaction.add(R.id.frameLayoutPalette, paletteFragment);

        fragmentTransaction.commit();

        Button clearAllBtn = findViewById(R.id.clearAllBtn);
        clearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((XMLFragment)bottomFragment).removeAllViews();
                ((XMLFragment)rightFragment).removeAllViews();
            }
        });

        View layoutView = findViewById(R.id.relativeLayoutContainer);
        layoutView.setOnDragListener(dragListener);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.infoMenuItem) {
            Intent myIntent = new Intent(getApplicationContext(), LessonInformationActivity.class);
            startActivity(myIntent);
            return true;
        } else if(id == android.R.id.home){
            finish();
            return true;
        }
        return true;
    }

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            View dragView = (View) event.getLocalState();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    int dragViewId = ((View)dragView.getParent().getParent()).getId();
                    if(bottomFragment.getId() == dragViewId)
                        ((XMLFragment)bottomFragment).removeViews(dragView.getId());
                    else if(rightFragment.getId() == dragViewId)
                        ((XMLFragment)rightFragment).removeViews(dragView.getId());
                    break;

            }
            return true;
        }
    };

    @Override
    public void onFragmentInteraction(View.OnDragListener dragListener) {

    }


    @Override
    public void removeViewForOtherFragment(int myFragmentId, int viewId) {
        if(bottomFragment.getId() == myFragmentId)
            ((XMLFragment)rightFragment).removeViews(viewId);
        else if(rightFragment.getId() == myFragmentId)
            ((XMLFragment)bottomFragment).removeViews(viewId);
    }
}
