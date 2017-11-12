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

import static com.yxsoong.project.androidacademy.R.id.widget7;
import static com.yxsoong.project.androidacademy.R.id.widget8;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab6 extends Fragment {


    public WidgetTab6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab6, container, false);

        String words = getString(R.string.widgetText7);

        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),97 ,116,0);
        TextView widgetText6 = view.findViewById(widget7);
        widgetText6.setText(ss1);

        words = getString(R.string.widgetText8);
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),34,174,0);
        TextView widgetText7 = view.findViewById(widget8);
        widgetText7.setText(ss1);

        return view;
    }

}
