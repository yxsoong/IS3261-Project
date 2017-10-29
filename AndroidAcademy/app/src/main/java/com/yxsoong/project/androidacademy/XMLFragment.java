package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link XMLFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class XMLFragment extends Fragment {
    private static String KEY = "orientation";
    private OnFragmentInteractionListener mListener;
    private LinearLayout linearLayout;
    private ArrayList<TextView> textViews;
    private ArrayList<Button> buttons;
    private ArrayList<EditText> editTexts;
    private ArrayList<View> views;

    public XMLFragment() {
        // Required empty public constructor
        textViews = new ArrayList<>();
        buttons = new ArrayList<>();
        editTexts = new ArrayList<>();
        views = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xml, container, false);
        linearLayout = view.findViewById(R.id.xmlFragmentLayout);
        Bundle bundle = getArguments();
        if(bundle.getString(KEY).equals("horizontal"))
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setOnDragListener(dragListener);
        return view;
    }

    public void setLongClick(final View view) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("viewType", view.getTag().toString());
                intent.putExtra("viewId", view.getId());
                ClipData data = ClipData.newIntent("myIntent", intent);
                //Log.i("view", data.toString());
                View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
                v.startDragAndDrop(data, myShadowBuilder, v, 0);
                return true;
            }
        });
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
                    //Log.i("ViewName", viewType);
                    if(viewType.equalsIgnoreCase("textView")) {
                        TextView textView = new TextView(getActivity());
                        textView.setText("Hello World");
                        textView.setTag("textView");
                        textView.setId(textViews.size());
                        textViews.add(textView);
                        setLongClick(textView);
                        Log.i("ID OF TV", "" + textView.getId());
                        linearLayout.addView(textView);
                    } else if(viewType.equalsIgnoreCase("button")){
                        Button button = new Button(getActivity());
                        button.setText("Button");
                        button.setTag("button");
                        button.setId(buttons.size());
                        buttons.add(button);
                        setLongClick(button);
                        linearLayout.addView(button);
                    } else if(viewType.equalsIgnoreCase("editText")){
                        EditText editText = new EditText(getActivity());
                        editText.setTag("editText");
                        editText.setId(views.size());
                        views.add(editText);
                        linearLayout.addView(editText);
                    } else if(viewType.equalsIgnoreCase("checkBox")){
                        CheckBox checkBox = new CheckBox(getActivity());
                        checkBox.setText("checkbox");
                        linearLayout.addView(checkBox);
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

    public void removeAllViews(){
        linearLayout.removeAllViews();
        views = new ArrayList<>();
    }

    public void removeViews(int viewId, String viewType){
        if(viewId == -1){
            Log.i("Error", "error");
            return;
        }
        if(viewType.equalsIgnoreCase("textView")) {
            TextView textView = textViews.get(viewId);
            textViews.set(viewId, null);
            linearLayout.removeView(textView);
        } else if(viewType.equalsIgnoreCase("button")){
            Button button = buttons.get(viewId);
            buttons.set(viewId, null);
            linearLayout.removeView(button);
        } else if(viewType.equalsIgnoreCase("editText")){
            EditText editText = (EditText) views.get(viewId);
            views.set(viewId, null);
            linearLayout.removeView(editText);
        }
    }
}
