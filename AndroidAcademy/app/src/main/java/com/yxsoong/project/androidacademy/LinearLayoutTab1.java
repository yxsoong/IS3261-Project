package com.yxsoong.project.androidacademy;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LinearLayoutTab1 extends Fragment implements XMLFragment.OnFragmentInteractionListener, PaletteFragment.OnFragmentInteractionListener{
    private static String ORIENTAION_KEY = "orientation";
    private static String LAYOUT_KEY = "layoutType";
    Fragment verticalFragment, horizontalFragment;

    public LinearLayoutTab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linear_layout_tab1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("layoutType", "linearLayout");
        bundle.putString("orientation", "vertical");
        verticalFragment = new XMLFragment();
        verticalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutVertical, verticalFragment);

        bundle = new Bundle();
        bundle.putString(LAYOUT_KEY, "linearLayout");
        bundle.putString(ORIENTAION_KEY, "horizontal");
        horizontalFragment = new XMLFragment();
        horizontalFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.frameLayoutHorizontal, horizontalFragment);

        fragmentTransaction.commit();

        Button clearAllBtn = view.findViewById(R.id.clearAllBtn);
        clearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((XMLFragment)verticalFragment).removeAllViews();
                ((XMLFragment)horizontalFragment).removeAllViews();
            }
        });

        View layoutView = view.findViewById(R.id.linearLayoutContainer);
        layoutView.setOnDragListener(dragListener);
    }

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
                    int dragViewId = ((View)dragView.getParent().getParent()).getId();
                    if(verticalFragment.getId() == dragViewId)
                        ((XMLFragment)verticalFragment).removeViews(dragView.getId());
                    else if(horizontalFragment.getId() == dragViewId)
                        ((XMLFragment)horizontalFragment).removeViews(dragView.getId());
                    break;

            }
            return true;
        }
    };

    @Override
    public void onFragmentInteraction(View.OnDragListener dragListener) {

    }


    @Override
    public void removeViewForOtherFragment(int myFragmentId, int viewId) {
        Log.i("viewID", myFragmentId + "");
        Log.i("fragmentID", verticalFragment.getId()+"");
        if(verticalFragment.getId() == myFragmentId)
            ((XMLFragment)horizontalFragment).removeViews(viewId);
        else if(horizontalFragment.getId() == myFragmentId)
            ((XMLFragment)verticalFragment).removeViews(viewId);
    }

}
