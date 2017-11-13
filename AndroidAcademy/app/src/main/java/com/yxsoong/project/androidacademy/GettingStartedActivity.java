package com.yxsoong.project.androidacademy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class GettingStartedActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.gettingStartedRecyclerView);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        String[] itemTitle = {"Create Project", "Android Emulator", "Android Manifest", "Android Widgets", "Task"};
        String[] itemDescriptions = {"Learn how to create your first project", "Setting up a virtual device for testing", "Information displayed in a manifest file","Handy widgets in Android Studios","Practice makes perfect"};
        int[] images = {R.drawable.folder_plus, R.drawable.cellphone_android, R.drawable.xml, R.drawable.settings, R.drawable.code_not_equal_variant};
        Class[] classes = {CreateProjectActivity.class, AndroidEmulatorActivity.class, AndroidManifestActivity.class, WidgetsActivity.class, GettingStartedTaskActivity.class};

        adapter = new LessonRecyclerAdapter(itemTitle,itemDescriptions,images,classes);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager)layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent();
        myIntent.putExtra("I_am_fine", "yes");
        setResult(RESULT_OK, myIntent);
        finish();
        return true;
    }

//    public void onClick_GoToCreateProjectActivity(View view){
//        Intent myIntent = new Intent(this, CreateProjectActivity.class);
//        startActivity(myIntent);
//    }
//
//    public void onClick_GoToAndroidEmulatorActivity(View view){
//        Intent myIntent = new Intent(this, AndroidEmulatorActivity.class);
//        startActivity(myIntent);
//    }
//    public void onClick_GoToAndroidManifestActivity(View view){
//        Intent myIntent = new Intent(this, AndroidManifestActivity.class);
//        startActivity(myIntent);
//    }
//    public void onClick_GoToWidgetsActivity(View view){
//        Intent myIntent = new Intent(this, WidgetsActivity.class);
//        startActivity(myIntent);
//    }
//
//    public void onClick_GoToTaskActivity(View view){
//        Intent myIntent = new Intent(this, GettingStartedTaskActivity.class);
//        startActivity(myIntent);
//    }
}
