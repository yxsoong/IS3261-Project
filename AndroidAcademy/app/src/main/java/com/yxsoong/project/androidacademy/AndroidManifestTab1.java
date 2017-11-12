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

import static com.yxsoong.project.androidacademy.R.id.manifestIntro2;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidManifestTab1 extends Fragment {


    public AndroidManifestTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_manifest_tab1, container, false);

        String words = getString(R.string.introManifest1);
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,25,0);
        TextView introManifest2 = view.findViewById(manifestIntro2);
        introManifest2.setText(ss1);

        words = getString(R.string.introManifest2);
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,45,0);


        TextView introManifest3 = view.findViewById(R.id.manifestIntro3);
        introManifest3.setText(ss1);

        words = getString(R.string.introManifest3);
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,42,0);
        TextView introManifest4 = view.findViewById(R.id.manifestIntro4);
        introManifest4.setText(ss1);

        words = getString(R.string.introManifest4);
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,65,0);
        TextView introManifest5 = view.findViewById(R.id.manifestIntro5);
        introManifest5.setText(ss1);




        return view;
    }

}
