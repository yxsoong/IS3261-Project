package com.yxsoong.project.androidacademy;


import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GettingStartedTaskInstructionsFragment extends Fragment {


    public GettingStartedTaskInstructionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_getting_started_task_instructions, container, false);

        String task = getResources().getString(R.string.getting_started_task);

        SpannableString ss1 = new SpannableString(task);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE), 31, 45, 0);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 31, 45, 0);
        TextView textView = view.findViewById(R.id.taskTV);
        textView.setText(ss1);

        task = getResources().getString(R.string.getting_started_task2);
        ss1 = new SpannableString(task);
        ss1.setSpan(new StyleSpan(Typeface.BOLD), 44, 66, 0);
        TextView textView2 = view.findViewById(R.id.taskTV2);
        textView2.setText(ss1);

        return view;
    }

}
