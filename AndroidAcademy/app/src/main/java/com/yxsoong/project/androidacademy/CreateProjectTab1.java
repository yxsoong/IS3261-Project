package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 22/10/2017.
 */

public class CreateProjectTab1 extends Fragment {

    public CreateProjectTab1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_project_tab1, container, false);
        return rootView;
    }
}
