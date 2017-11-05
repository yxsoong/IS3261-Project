package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

public class WidgetsActivity extends Activity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
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
                    WidgetTab1 tab1 = new WidgetTab1();
                    return tab1;
                case 1:
                    WidgetTab2 tab2 = new WidgetTab2();
                    return tab2;
                case 2:
                    WidgetTab3 tab3 = new WidgetTab3();
                    return tab3;
                case 3:
                    WidgetTab4 tab4 = new WidgetTab4();
                    return tab4;
                case 4:
                    WidgetTab5 tab5 = new WidgetTab5();
                    return tab5;
                case 5:
                    WidgetTab6 tab6 = new WidgetTab6();
                    return tab6;
                case 6:
                    WidgetTab7 tab7 = new WidgetTab7();
                    return tab7;
                case 7:
                    WidgetTab8 tab8 = new WidgetTab8();
                    return tab8;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 8;
        }


    }
}
