package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

public class AndroidEmulatorActivity extends Activity {

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

        ActionBar actionBar = getActionBar();
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
