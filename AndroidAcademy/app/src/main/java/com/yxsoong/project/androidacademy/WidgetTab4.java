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

import static com.yxsoong.project.androidacademy.R.id.widget5;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab4 extends Fragment {


    public WidgetTab4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab4, container, false);

        String words = "Click and drag the bottom left corner of the widget list to get a clearer view of the widgets.\n" +
                "To use a widget, simply click and drag the widget onto the screen display.";
        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),94,169,0);
        TextView widgetText3 = view.findViewById(widget5);
        widgetText3.setText(ss1);

        return view;
    }

}
