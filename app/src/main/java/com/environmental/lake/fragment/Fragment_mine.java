package com.environmental.lake.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.environmental.lake.environmental.LoginActivity;
import com.environmental.lake.environmental.R;

/**
 * by lake
 */
public class Fragment_mine extends Fragment implements View.OnClickListener{
    private final static String TAG="Fragment_mine";
    private LinearLayout Lnlay_login;

    public Fragment_mine() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_mine, container, false);
        FindView(v);
        return v;

    }
    private void FindView(View v){
        Lnlay_login=(LinearLayout)v.findViewById(R.id.Lnlay_login);

        Lnlay_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Lnlay_login:
                Log.e(TAG, "onClick: ");
                Intent intent=new Intent();
                intent.setClass(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
