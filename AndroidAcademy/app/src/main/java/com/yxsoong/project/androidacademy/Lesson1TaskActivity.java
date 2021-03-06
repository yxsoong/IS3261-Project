package com.yxsoong.project.androidacademy;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.HashSet;
import java.util.Set;

public class Lesson1TaskActivity extends AppCompatActivity {

    public static final String PAGES_VIEW_KEY = "pagesViewed";
    public static final String PROGRESS_KEY = "progress";
    public static final String ANDROID_ACADEMY_SHAREDPREF = "androidAcademySharedPref1";

    int progress;
    Set<String> pagesVisited;
    SharedPreferences prefs;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    public static final String URLKEY = "urlAnswers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_task);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        prefs = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE);
        progress = prefs.getInt(PROGRESS_KEY, 0);
        pagesVisited = prefs.getStringSet(PAGES_VIEW_KEY, new HashSet<String>());

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarActionBar);

        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        mTabLayout.addTab(mTabLayout.newTab().setText("Your Tab Title"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Your Tab Title"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson1_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(getApplicationContext(), TaskAnswerActivity.class);
            myIntent.putExtra(URLKEY, "https://raw.githubusercontent.com/yxsoong/IS3261-Project/master/AndroidAcademy/app/src/main/res/layout/fragment_lesson1_task_example.xml");
            startActivity(myIntent);
            if(!pagesVisited.contains("Lesson1Answer")){
                pagesVisited.add("Lesson1Answer");
                SharedPreferences.Editor editor = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE).edit();
                editor.putStringSet(PAGES_VIEW_KEY, pagesVisited);
                progress+=5;
                editor.putInt(PROGRESS_KEY, progress);
                editor.commit();
            }
            return true;
        } else if(id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Lesson1TaskInstructionsFragment tab1 = new Lesson1TaskInstructionsFragment();
                    return tab1;
                case 1:
                    Lesson1TaskExampleFragment tab2 = new Lesson1TaskExampleFragment();
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Instructions";
                case 1:
                    return "Example";
                default:
                    return null;
            }
        }
    }
}
