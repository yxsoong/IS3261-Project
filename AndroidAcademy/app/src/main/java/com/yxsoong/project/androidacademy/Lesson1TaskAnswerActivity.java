package com.yxsoong.project.androidacademy;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Lesson1TaskAnswerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_task_answer);

        TextView textView = findViewById(R.id.textview1);

        XmlResourceParser xmlResourceParser = getResources().getLayout(R.layout.fragment_lesson1_task_example);
        int eventType = 0;
        try {
            eventType = xmlResourceParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                    System.out.println("Start document");
                } else if (eventType == XmlPullParser.START_TAG) {
                    System.out.println("Start tag " + xmlResourceParser.getName());
                } else if (eventType == XmlPullParser.END_TAG) {
                    System.out.println("End tag " + xmlResourceParser.getName());
                } else if (eventType == XmlPullParser.TEXT) {
                    String text = textView.getText().toString();
                    textView.setText(text + xmlResourceParser.getText());
                    System.out.println("Text " + xmlResourceParser.getText());
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException | IOException e) {


        }



        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
