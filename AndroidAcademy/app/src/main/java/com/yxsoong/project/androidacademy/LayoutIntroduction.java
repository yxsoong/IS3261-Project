package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
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
        textView2.setText(ss1);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
