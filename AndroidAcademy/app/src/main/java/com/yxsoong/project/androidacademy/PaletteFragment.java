package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PaletteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PaletteFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_palette, container, false);
        //TextView textView = view.findViewById(R.id.textViewPaletteTV);
        ImageView textViewIV = view.findViewById(R.id.textViewPaletteIV);
        //Button button = view.findViewById(R.id.buttonPaletteBtn);
        ImageView buttonIV = view.findViewById(R.id.buttonPaletteIV);
        ImageView editTextIV = view.findViewById(R.id.editTextPaletteIV);
        ImageView checkBoxIV = view.findViewById(R.id.checkBoxPaletteIV);

        textViewIV.setOnLongClickListener(longClickListener);
        buttonIV.setOnLongClickListener(longClickListener);
        editTextIV.setOnLongClickListener(longClickListener);
        checkBoxIV.setOnLongClickListener(longClickListener);
//        setLongClick(textView);
//        setLongClick(button);
//        setLongClick(editTextIV);
//        setLongClick(checkBoxIV);

        return view;
    }

    /*public void setLongClick(final View view) {
        final View finalView = view;
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("viewType", view.getTag().toString());
                ClipData data = ClipData.newIntent("myIntent", intent);
                //Log.i("view", data.toString());
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(data, myShadowBuilder, v, 0);
                return true;
            }
        });
    }*/

    View.OnLongClickListener longClickListener = new View.OnLongClickListener(){

        @Override
        public boolean onLongClick(View v) {
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            ClipData data = ClipData.newPlainText("label", "text");
            v.startDragAndDrop(data, myShadowBuilder, v, 0);
            return true;
        }
    };
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) getParentFragment();
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
        void onFragmentInteraction(View.OnDragListener dragListener);
    }
}
