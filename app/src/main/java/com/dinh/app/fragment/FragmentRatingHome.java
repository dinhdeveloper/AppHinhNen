package com.dinh.app.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinh.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRatingHome extends Fragment {


    public FragmentRatingHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_rating, container, false);
    }

}
