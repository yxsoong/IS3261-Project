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

import static com.yxsoong.project.androidacademy.R.id.widget4;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab3 extends Fragment {


    public WidgetTab3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab3, container, false);

        String words = "You should see a preview of what the app looks on an android device once the app is run. \n" +
                "We can find the available widgets on the top left of the edit panel. ";
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),87,159,0);
        TextView widgetText3 = view.findViewById(widget4);
        widgetText3.setText(ss1);

        return view;
    }

}
