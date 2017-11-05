package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.widget.TextView;

public class LayoutIntroduction extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_introduction);


        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String words = "What is a layout?\n" +
                "A layout defines the visual structure for a user interface, such as the UI for an activity or app widget. You can declare a layout in two ways:";

        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView = findViewById(R.id.layoutTxt1);
        textView.setText(ss1);

        words = "Declare UI elements in XML. Android provides a straightforward XML vocabulary that corresponds to the View classes and subclasses, such as those for widgets and layouts.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView2 = findViewById(R.id.layoutTxt2);
        textView2.setText(ss1);

        words = "Instantiate layout elements at runtime. Your application can create View and ViewGroup objects (and manipulate their properties) programmatically.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView3 = findViewById(R.id.layoutTxt3);
        textView3.setText(ss1);

        words = "organizes its children into a single horizontal or vertical row. It creates a scrollbar if the length of the window exceeds the length of the screen.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView4 = findViewById(R.id.layoutTxt4);
        textView4.setText(ss1);

        words = "Enables you to specify the location of child objects relative to each other (child A to the left of child B) or to the parent (aligned to the top of the parent).";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView5 = findViewById(R.id.layoutTxt5);
        textView5.setText(ss1);

        words = "Displays web pages.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 5, 0);
        TextView textView6 = findViewById(R.id.layoutTxt6);
        textView6.setText(ss1);

        words = "Displays a scrolling grid of columns and rows.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView7 = findViewById(R.id.layoutTxt7);
        textView7.setText(ss1);

        words = "Displays a scrolling single column list.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 0, 20, 0);
        TextView textView8 = findViewById(R.id.layoutTxt8);
        textView8.setText(ss1);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
