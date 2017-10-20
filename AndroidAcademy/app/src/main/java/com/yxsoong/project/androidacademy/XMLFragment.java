package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link XMLFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class XMLFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public XMLFragment() {
        // Required empty public constructor
    }

    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xml, container, false);
        linearLayout = view.findViewById(R.id.xmlFragmentLayout);
        linearLayout.setOnDragListener(dragListener);
        return view;
    }

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    String viewType = event.getClipData().getItemAt(0).getIntent().getStringExtra("viewType");
                    Log.i("ViewName", viewType);
                    if(viewType.equalsIgnoreCase("android.widget.TextView")) {
                        TextView textView = new TextView(getActivity());
                        textView.setText("Hello World");
                        linearLayout.addView(textView);
                    } else if(viewType.equalsIgnoreCase("android.widget.Button")){
                        Button button = new Button(getActivity());
                        button.setText("Button");
                        linearLayout.addView(button);
                    }
                    break;
            }
            return true;
        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
