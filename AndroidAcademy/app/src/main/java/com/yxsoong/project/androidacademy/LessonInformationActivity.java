package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class LessonInformationActivity extends Activity {

    ViewFlipper viewFlipper;
    ImageView crossIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_information);

        viewFlipper = findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
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
