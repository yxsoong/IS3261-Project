package com.yxsoong.project.androidacademy;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidEmulatorTab2 extends Fragment {


    public AndroidEmulatorTab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_emulator_tab2, container, false);

        String words = "Select either O or Nougat under the Recommended tab. " +
                "If you see Download next to the system image, you need to download the system image.";
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new StyleSpan(Typeface.BOLD),14,15,0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD),19,26,0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD),64,73,0);
        TextView selectSystemImageTV = view.findViewById(R.id.selectSystemImageTV);
        selectSystemImageTV.setText(ss1);
        return view;
    }

}
