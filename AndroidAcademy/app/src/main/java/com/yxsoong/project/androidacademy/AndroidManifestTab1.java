package com.yxsoong.project.androidacademy;


import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.yxsoong.project.androidacademy.R.id.manifestIntro2;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidManifestTab1 extends Fragment {


    public AndroidManifestTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android_manifest_tab1, container, false);

        String words = "It is a file the provices essential information about your app on the Android System. The system\n" +
                "requires these information before it can run any of the app's code.";
        SpannableString ss1 = new SpannableString(words);

        TextView introManifest2 = view.findViewById(manifestIntro2);
        introManifest2.setText(ss1);

        /*words = "To open AVD Manager, go to Tools > Android > AVD Manger";
        ss1 = new SpannableString(words);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),27,32,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),35,42,0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLUE),45,words.length(),0);

        TextView openAVDTV = view.findViewById(R.id.openAVDTV);
        openAVDTV.setText(ss1);

        words = "Click Create Virtual Device, at the bottom of the AVD Manager dialog.";
        ss1 = new SpannableString(words);
        ss1.setSpan(new StyleSpan(Typeface.BOLD),6,27,0);
        TextView clickOnCreateTV = view.findViewById(R.id.clickOnCreateTV);
        clickOnCreateTV.setText(ss1);*/

        return view;
    }

}
