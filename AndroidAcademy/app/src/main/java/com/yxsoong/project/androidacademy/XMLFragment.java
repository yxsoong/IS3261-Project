package com.yxsoong.project.androidacademy;

import android.app.Fragment;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link XMLFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class XMLFragment extends Fragment {
    private static String ORIENTAION_KEY = "orientation";
    private static String LAYOUT_KEY = "layoutType";
    private static String TAG = "fragmentXML";
    private OnFragmentInteractionListener mListener;
    private ViewGroup layout;

    public XMLFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xml, container, false);
        //linearLayout = view.findViewById(R.id.xmlFragmentLayout);
        Bundle bundle = getArguments();
        if(bundle.getString(LAYOUT_KEY).equals("linearLayout")) {
            layout = new LinearLayout(getContext());
            layout.setId(View.generateViewId());
            layout.setBackgroundResource(R.color.lightGrey);
            layout.setTag(TAG);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(10,10,10,10);
            if(bundle.getString(ORIENTAION_KEY).equals("horizontal"))
                ((LinearLayout)layout).setOrientation(LinearLayout.HORIZONTAL);
            else
                ((LinearLayout)layout).setOrientation(LinearLayout.VERTICAL);
            container.addView(layout, layoutParams);
        } else if(bundle.getString(LAYOUT_KEY).equals("relativeLayout")){
            layout = new RelativeLayout(getContext());
            layout.setId(View.generateViewId());
            layout.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.lightGrey));
            layout.setTag(TAG);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(10,10,10,10);
            Log.i("in1", "in1");
            if(bundle.getString(ORIENTAION_KEY).equals("bottom")) {
                Log.i("in", "in");
                ((RelativeLayout) layout).setGravity(Gravity.BOTTOM);
            }else
                ((RelativeLayout)layout).setGravity(Gravity.RIGHT);
            container.addView(layout, layoutParams);
        }

        layout.setOnDragListener(dragListener);
        return view;
    }

    /*public void setLongClick(final View view) {
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

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            View dragView = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    /*int dragViewParentId = ((View)dragView.getParent()).getId();
                    if(dragViewParentId == linearLayout.getId()){
                        break;
                    }*/

                    String dragViewParentTag = ((View) dragView.getParent()).getTag().toString();

                    if(dragViewParentTag.equals(TAG)){
                        int dragViewParentId = ((View)dragView.getParent()).getId();
                        if(dragViewParentId == layout.getId()){
                            break;
                        }
                        int parentId = ((View) layout.getParent()).getId();
                        mListener.removeViewForOtherFragment(parentId, dragView.getId());
                    }


                    if(dragView instanceof CheckBox) {
                        CheckBox checkBox = new CheckBox(getActivity());
                        checkBox.setText("checkbox");
                        checkBox.setId(View.generateViewId());
                        checkBox.setOnLongClickListener(longClickListener);
                        layout.addView(checkBox);
                    } else if(dragView instanceof Button) {
                        Button button = new Button(getActivity());
                        button.setText("Button");
                        button.setId(View.generateViewId());
                        button.setOnLongClickListener(longClickListener);
                        layout.addView(button);
                    } else if(dragView instanceof ImageView) {
                        if(dragView.getTag().equals("editText")) {
                            EditText editText = new EditText(getActivity());
                            editText.setId(View.generateViewId());
                            editText.setOnLongClickListener(longClickListener);
                            layout.addView(editText);
                        } else if(dragView.getTag().equals("checkBox")) {
                            CheckBox checkBox = new CheckBox(getActivity());
                            checkBox.setText("checkbox");
                            checkBox.setId(View.generateViewId());
                            checkBox.setOnLongClickListener(longClickListener);
                            layout.addView(checkBox);
                        } else if(dragView.getTag().equals("textView")) {
                            TextView textView = new TextView(getActivity());
                            textView.setText("Hello World");
                            textView.setId(View.generateViewId());
                            textView.setOnLongClickListener(longClickListener);
                            layout.addView(textView);
                        } else if(dragView.getTag().equals("button")) {
                            Button button = new Button(getActivity());
                            button.setText("Button");
                            button.setId(View.generateViewId());
                            button.setOnLongClickListener(longClickListener);
                            layout.addView(button);
                        }
                    } else if(dragView instanceof EditText) {
                        EditText editText = new EditText(getActivity());
                        editText.setId(View.generateViewId());
                        editText.setOnLongClickListener(longClickListener);
                        layout.addView(editText);
                    } else if(dragView instanceof TextView) {
                        TextView textView = new TextView(getActivity());
                        textView.setText("Hello World");
                        textView.setId(View.generateViewId());
                        textView.setOnLongClickListener(longClickListener);
                        layout.addView(textView);
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
        void removeViewForOtherFragment(int myFragmentId, int viewId);
    }

    public void removeAllViews(){
        layout.removeAllViews();
    }

    public void removeViews(int viewId){
        if(viewId == -1){
            Log.i("Error", "error");
            return;
        }

        View view = getActivity().findViewById(viewId);
        layout.removeView(view);
    }
}
