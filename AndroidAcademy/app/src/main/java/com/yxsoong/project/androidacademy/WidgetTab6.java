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

        String words = "Let's try to edit the words shown through the TextView widget." +
                "First, open the Strings library in Res/Values/Strings." +
                "You should be able to see a line of code in the Strings.xml file.";

        SpannableString ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),97 ,115,0);
        TextView widgetText6 = view.findViewById(widget7);
        widgetText6.setText(ss1);

        words = "A String refers to a line of words." +
                "Each line of code consists of 2 pieces of information: The name of the string that points the program to the string, and the string itself." +
                "In the example above, the red box is where the name of the string is, and the blue box is the actual string.";

        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),34,174,0);
        TextView widgetText7 = view.findViewById(widget8);
        widgetText7.setText(ss1);

        return view;
    }

}
