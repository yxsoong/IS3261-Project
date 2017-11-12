package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class RegisterActivity extends Activity {

    public static final String USER_KEY = "user";
    public static final String PROGRESS_KEY = "progress";
    public static final String PAGES_VIEW_KEY = "pagesViewed";
    public static final String ANDROID_ACADEMY_SHAREDPREF = "androidAcademySharedPref1";

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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
}
