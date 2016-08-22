package com.environmental.lake.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.environmental.lake.environmental.R;

public class Fragment_ad extends Fragment {
    private static final String ARG_PARAM = "number";

    // TODO: Rename and change types of parameters
    private int mNumber;
    private ImageView mIageView;
    public Fragment_ad() {

    }
    public static Fragment_ad newInstance(int number) {
        Fragment_ad fragment = new Fragment_ad();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNumber = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ad, container, false);
        mIageView=(ImageView)view.findViewById(R.id.ad_imgeview);
        switch (mNumber){
            case 1:
                mIageView.setBackgroundResource(R.color.color_green);
                break;
            case 2:
                mIageView.setBackgroundResource(R.color.color_blue);
                break;
            case 3:
                mIageView.setBackgroundResource(R.color.color_orange);
                break;
            case 4:
                mIageView.setBackgroundResource(R.color.colorAccent);
                break;
            case 5:
                mIageView.setBackgroundResource(R.color.colorBlack);
                break;
            default:
                break;
        }
        return view;
    }

}
