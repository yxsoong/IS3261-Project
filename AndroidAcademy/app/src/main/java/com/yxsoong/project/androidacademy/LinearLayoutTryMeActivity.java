package com.yxsoong.project.androidacademy;

import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LinearLayoutTryMeActivity extends AppCompatActivity implements XMLFragment.OnFragmentInteractionListener, PaletteFragment.OnFragmentInteractionListener{
    private static String ORIENTAION_KEY = "orientation";
    private static String LAYOUT_KEY = "layoutType";
    Fragment verticalFragment, horizontalFragment, paletteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_try_me);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("layoutType", "linearLayout");
        bundle.putString("orientation", "vertical");
        verticalFragment = new XMLFragment();
        verticalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutVertical, verticalFragment);

        bundle = new Bundle();
        bundle.putString(LAYOUT_KEY, "linearLayout");
        bundle.putString(ORIENTAION_KEY, "horizontal");
        horizontalFragment = new XMLFragment();
        horizontalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutHorizontal, horizontalFragment);

        paletteFragment = new PaletteFragment();
        fragmentTransaction.add(R.id.frameLayoutPalette, paletteFragment);

        fragmentTransaction.commit();

        Button clearAllBtn = findViewById(R.id.clearAllBtn);
        clearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((XMLFragment)verticalFragment).removeAllViews();
                ((XMLFragment)horizontalFragment).removeAllViews();
            }
        });

        View layoutView = findViewById(R.id.linearLayoutContainer);
        layoutView.setOnDragListener(dragListener);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
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
                    if(verticalFragment.getId() == dragViewId)
                        ((XMLFragment)verticalFragment).removeViews(dragView.getId());
                    else if(horizontalFragment.getId() == dragViewId)
                        ((XMLFragment)horizontalFragment).removeViews(dragView.getId());
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
        if(verticalFragment.getId() == myFragmentId)
            ((XMLFragment)horizontalFragment).removeViews(viewId);
        else if(horizontalFragment.getId() == myFragmentId)
            ((XMLFragment)verticalFragment).removeViews(viewId);
    }

    public void onClick_GoToLinearLayoutActivity(View view){
        Intent myIntent = new Intent(this, LinearLayoutActivity.class);
        startActivity(myIntent);
    }
}
