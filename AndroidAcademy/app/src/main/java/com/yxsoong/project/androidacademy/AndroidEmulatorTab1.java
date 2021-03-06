package com.yxsoong.project.androidacademy;


import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidEmulatorTab1 extends Fragment {


    public AndroidEmulatorTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_android_emulator_tab1, container, false);

        String words = getString(R.string.emulatorText1);
        SpannableString ss1 = new SpannableString(words);

        ss1.setSpan(new ForegroundColorSpan(Color.RED),17,27,0);
        ss1.setSpan(new UnderlineSpan(),17,27,0);
        TextView intelHAXMTV = view.findViewById(R.id.intelHAXMTV);
        intelHAXMTV.setText(ss1);

        words = getString(R.string.emulatorText2);
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),27,32,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),35,42,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),45,words.length(),0);

        TextView openAVDTV = view.findViewById(R.id.openAVDTV);
        openAVDTV.setText(ss1);

        words = getString(R.string.emulatorText3);
        ss1 = new SpannableString(words);
        ss1.setSpan(new StyleSpan(Typeface.BOLD),6,27,0);
        TextView clickOnCreateTV = view.findViewById(R.id.clickOnCreateTV);
        clickOnCreateTV.setText(ss1);

        return view;
    }

}
