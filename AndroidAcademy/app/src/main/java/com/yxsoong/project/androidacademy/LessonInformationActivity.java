package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class LessonInformationActivity extends Activity {

    ViewFlipper viewFlipper;
    ImageView crossIv;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_information);

        count = 0;
        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 2) {
                    finish();
                    return;
                }
                viewFlipper.showNext();
                count++;


            }
        });

        crossIv = findViewById(R.id.imageView4);
        crossIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
