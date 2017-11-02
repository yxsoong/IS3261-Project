package com.yxsoong.project.androidacademy;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import static com.yxsoong.project.androidacademy.R.id.manifestIntro6;
import static com.yxsoong.project.androidacademy.R.id.manifestIntro7;
import static com.yxsoong.project.androidacademy.R.id.manifestIntro8;
import static com.yxsoong.project.androidacademy.R.id.manifestIntro9;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidManifestTab2 extends Fragment {


    public AndroidManifestTab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_manifest_tab2, container, false);



        String words = "It declares the permissions that the application must have to:\n" +
                "- access protected parts of the API\n" +
                "interact with other apps.\n" +
                "- interact with the application's components.";

        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,62,0);
        TextView introManifest6 = view.findViewById(manifestIntro6);
        introManifest6.setText(ss1);

        words = "It lists the Instrumentation classes which are present in the manifest only while the application is being developed and are removed before the application is published.";
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,36,0);
        TextView introManifest7 = view.findViewById(manifestIntro7);
        introManifest7.setText(ss1);

        words = "It declares the minimum level of the Android API that the application requires.";
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,79,0);
        TextView introManifest8 = view.findViewById(manifestIntro8);
        introManifest8.setText(ss1);

        words = "It lists the libraries that the application must be linked against.";
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,67,0);
        TextView introManifest9 = view.findViewById(manifestIntro9);
        introManifest9.setText(ss1);



        return view;
    }

}
