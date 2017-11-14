package com.yxsoong.project.androidacademy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class RegisterActivity extends AppCompatActivity{

    public static final String USER_KEY = "user";
    public static final String PROGRESS_KEY = "progress";
    public static final String PAGES_VIEW_KEY = "pagesViewed";
    public static final String ANDROID_ACADEMY_SHAREDPREF = "androidAcademySharedPref1";
    public static final String VIEW_INFO_KEY = "viewInfoPage";

    EditText editText;
    Button button;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarActionBar);
//        //ActionBar actionBar = getSupportActionBar();
//
//        setSupportActionBar(myToolbar);
//        ActionBar ab = getSupportActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);
//
//        mTabLayout = findViewById(R.id.tabLayout);
//        mViewPager = findViewById(R.id.viewPager);
//
//        mTabLayout.addTab(mTabLayout.newTab().setText("Your Tab Title"));
//        mTabLayout.addTab(mTabLayout.newTab().setText("Your Tab Title"));
//        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
//        mTabLayout.setupWithViewPager(mViewPager);
//
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Log.i("click","clicked");
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        SharedPreferences prefs = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE);
        String text = prefs.getString(USER_KEY, null);

        if(text != null){
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
            finish();
        } else{
            editText = findViewById(R.id.editText1);
            button = findViewById(R.id.button1);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editText.getText().toString();

                    if(name.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Please enter your name!", Toast.LENGTH_LONG).show();
                        return;
                    }

                    SharedPreferences.Editor editor = getSharedPreferences(ANDROID_ACADEMY_SHAREDPREF, MODE_PRIVATE).edit();

                    editor.putString(USER_KEY, name);
                    editor.putInt(PROGRESS_KEY, 0);
                    editor.putBoolean(VIEW_INFO_KEY, false);
                    Set<String> stringSet = new HashSet<String>();
                    editor.putStringSet(PAGES_VIEW_KEY, stringSet);
                    editor.commit();

                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            });
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

//    public class ViewPagerAdapter extends FragmentPagerAdapter{
//
//        public ViewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            switch (position){
//                case 0:
//                    TestFragment tab1 = new TestFragment();
//                    return tab1;
//                case 1:
//                    TestFragment tab2 = new TestFragment();
//                    return tab2;
//                default:
//                    return null;
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return 2;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position){
//                case 0:
//                    return "Instructions";
//                case 1:
//                    return "Example";
//                default:
//                    return null;
//            }
//        }
//    }
}
