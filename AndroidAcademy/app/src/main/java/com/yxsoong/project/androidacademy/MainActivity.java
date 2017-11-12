package com.yxsoong.project.androidacademy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String USER_KEY = "user";
    public static final String PROGRESS_KEY = "progress";
    public static final String ANDROID_ACADEMY_SHAREDPREF = "androidAcademySharedPref1";
    public static final int REQUEST_CODE = 1;
    //    Button lesson1Btn, lesson2Btn, lesson3Btn, lesson4Btn, testBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ProgressBar progressBar;
    TextView nameTV, progressTV;

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

        SharedPreferences prefs = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE);
        String name = prefs.getString(USER_KEY, null);
        int progress = prefs.getInt(PROGRESS_KEY, 0);

        progressBar = findViewById(R.id.progressBar);
        nameTV = findViewById(R.id.nameTV);
        progressTV = findViewById(R.id.progress);

        nameTV.setText(name);
        progressBar.setProgress(progress);
        progressTV.setText(progress + "%");

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainRecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.getLayoutManager().getItemCount();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("resultCode", data + "");
        if (requestCode == REQUEST_CODE) {
            SharedPreferences prefs = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE);
            int progress = prefs.getInt(PROGRESS_KEY, 0);

            progressBar.setProgress(progress);
            progressTV.setText(progress + "%");
        }
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
