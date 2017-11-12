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

import static com.yxsoong.project.androidacademy.R.id.widget8;
import static com.yxsoong.project.androidacademy.R.id.widget9;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab7 extends Fragment {


    public WidgetTab7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab7, container, false);

        String words = "To create a new String in the program, simply type in <string name=\"string_name\">My New String </string>, and fill in the string name and string parts of the code in the next line";

        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),53 ,104,0);
        TextView widgetText6 = view.findViewById(widget8);
        widgetText6.setText(ss1);

        words = "Return to the layout XML file, and in the <TextView../> sections of the codes, notice the line android:text=\"Hello World!\".\nChange the text by deleting Hello World! and typing @string/, followed by your string name.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),41,55,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),95,124,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),175,183,0);
        TextView widgetText7 = view.findViewById(widget9);
        widgetText7.setText(ss1);

        return view;
    }

}
