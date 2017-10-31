package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.MenuItem;
import android.widget.TextView;

public class GettingStartedTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started_task);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String task = getResources().getString(R.string.getting_started_task);

        SpannableString ss1 = new SpannableString(task);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 34, 48, 0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 34, 48, 0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 0, 4, 0);
        TextView textView = findViewById(R.id.taskTV);

        textView.setText(ss1);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
