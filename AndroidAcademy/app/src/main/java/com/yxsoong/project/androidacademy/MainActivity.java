package com.yxsoong.project.androidacademy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity{

//    Button lesson1Btn, lesson2Btn, lesson3Btn, lesson4Btn, testBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction;
//
//        fragmentTransaction = fragmentManager.beginTransaction();
//        MainViewFragment mainFragment = new MainViewFragment();
//        fragmentTransaction.add(R.id.mainLayout1, mainFragment);
//        fragmentTransaction.commit();

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainRecyclerAdapter();
        recyclerView.setAdapter(adapter);

    }


//    @Override
//    public void switchActivity(String activity) {
//        Intent myIntent = null;
//        if(activity.equals("GettingStartedActivity")){
//            myIntent = new Intent(this, GettingStartedActivity.class);
//        } else if(activity.equals("Lesson1Activity")) {
//            myIntent = new Intent(this, Lesson1Activity.class);
//        } else if(activity.equals("Lesson2Activity")){
//            myIntent = new Intent(this, Lesson2Activity.class);
//        }
//        if(myIntent != null)
//            startActivity(myIntent);
//    }
}
