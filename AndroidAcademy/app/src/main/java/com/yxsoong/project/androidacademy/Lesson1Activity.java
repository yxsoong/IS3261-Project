package com.yxsoong.project.androidacademy;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class Lesson1Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.lesson1RecyclerView);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        String[] itemTitle = {"Introduction to Layouts", "Linear Layout", "Relative Layout", "List View", "Grid View", "Task"};
        String[] itemDescriptions = {"What layouts are and how to use them", "Step-by-step guide to using Linear Layouts", "Step-by-step guide to using Linear Layouts", "What ListView is and how to use it","What GridView is and how to use it","Practice makes perfect"};
        int[] images = {R.drawable.information_outline, R.drawable.reorder_vertical, R.drawable.trello, R.drawable.server, R.drawable.view_grid, R.drawable.code_not_equal_variant};
        Class[] classes = {LayoutIntroduction.class, LinearLayoutTryMeActivity.class, null, null, null, Lesson1TaskActivity.class};

        adapter = new LessonRecyclerAdapter(itemTitle,itemDescriptions,images,classes);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager)layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);

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

//    public void onClick_GoToLinearLayoutActivity(View view){
//        Intent myIntent = new Intent(this, LinearLayoutTryMeActivity.class);
//        startActivity(myIntent);
//    }
//
//    public void onClick_GoToLayoutIntroduction(View view){
//        Intent myIntent = new Intent(this, LayoutIntroduction.class);
//        startActivity(myIntent);
//    }
//
//    public void onClick_GoToLesson1TaskActivity(View view){
//        Intent myIntent = new Intent(this, Lesson1TaskActivity.class);
//        startActivity(myIntent);
//    }

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
