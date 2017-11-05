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

import static com.yxsoong.project.androidacademy.R.id.widget6;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab5 extends Fragment {


    public WidgetTab5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab5, container, false);

        String words = "Click the text tab to look at the codes. Notice that a new section of codes has been added. \n" +
                "Dragging the widget on the Design view generates a new set of default codes automatically. \n" +
                "We can edit the position, size and words on the widget by editing these codes.";
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),90,184,0);
        TextView widgetText3 = view.findViewById(widget6);
        widgetText3.setText(ss1);





        return view;
    }

}
