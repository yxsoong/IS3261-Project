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

import static com.yxsoong.project.androidacademy.R.id.widget2;
import static com.yxsoong.project.androidacademy.R.id.widget3;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab2 extends Fragment {


    public WidgetTab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab2, container, false);

        String words = "To see the widgets available for use, simply open the XML file:";
        SpannableString ss1 = new SpannableString(words);
        TextView widgetText3 = view.findViewById(widget3);
        widgetText3.setText(ss1);

        words = "The list of widgets provided by android studios can be found when an XML file is created. \n" +
                "XML files can usually be found under the res/layout/ folder in Android Studios.";
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),132,144,0);
        TextView widgetText2 = view.findViewById(widget2);
        widgetText2.setText(ss1);

        return view;
    }

}
