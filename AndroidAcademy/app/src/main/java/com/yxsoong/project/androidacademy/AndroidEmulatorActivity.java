package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.HashSet;
import java.util.Set;

public class AndroidEmulatorActivity extends AppCompatActivity {
    public static final String PAGES_VIEW_KEY = "pagesViewed";
    public static final String PROGRESS_KEY = "progress";
    public static final String ANDROID_ACADEMY_SHAREDPREF = "androidAcademySharedPref1";

    int progress;
    Set<String> pagesVisited;
    SharedPreferences prefs;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_emulator);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        prefs = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE);
        progress = prefs.getInt(PROGRESS_KEY, 0);
        pagesVisited = prefs.getStringSet(PAGES_VIEW_KEY, new HashSet<String>());

//        ActionBar actionBar = getActionBar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    AndroidEmulatorTab1 tab1 = new AndroidEmulatorTab1();
                    return tab1;
                case 1:
                    AndroidEmulatorTab2 tab2 = new AndroidEmulatorTab2();
                    return tab2;
                case 2:
                    AndroidEmulatorTab3 tab3 = new AndroidEmulatorTab3();
                    return tab3;
                case 3:
                    AndroidEmulatorTab4 tab4 = new AndroidEmulatorTab4();

                    if(!pagesVisited.contains("AndroidEmulator")){
                        pagesVisited.add("AndroidEmulator");
                        SharedPreferences.Editor editor = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE).edit();
                        editor.putStringSet(PAGES_VIEW_KEY, pagesVisited);
                        progress+=2;
                        editor.putInt(PROGRESS_KEY, progress);
                        editor.commit();
                    }
                    return tab4;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 4;
        }


    }
}
