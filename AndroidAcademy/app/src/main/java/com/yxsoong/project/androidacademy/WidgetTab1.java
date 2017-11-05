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

import static com.yxsoong.project.androidacademy.R.id.widget1;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab1 extends Fragment {


    public WidgetTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_widget_tab1, container, false);

        String words = "What are Widgets?\n"+
                "The Widget package contains mostly visual User-Interface elements that you can use on our Application Screen. In Android Studios, there are pre-included widgets that you are able to use in the .xml files, such as TextView, Buttons, and many more.";
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),0,25,0);
        TextView introManifest2 = view.findViewById(widget1);
        introManifest2.setText(ss1);
        return view;
    }

}
