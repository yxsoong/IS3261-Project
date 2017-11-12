package com.yxsoong.project.androidacademy;


import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.yxsoong.project.androidacademy.R.id.widget10;


/**
 * A simple {@link Fragment} subclass.
 */
public class WidgetTab8 extends Fragment {


    public WidgetTab8() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_widget_tab8, container, false);
        String words = getString(R.string.widgetText3);

        SpannableString ss1 = new SpannableString(words);
        TextView widgetText10 = view.findViewById(widget10);
        widgetText10.setText(ss1);

        return view;
    }

}
