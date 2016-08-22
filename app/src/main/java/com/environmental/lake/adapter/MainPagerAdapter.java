package com.environmental.lake.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.environmental.lake.fragment.Fragment_main;
import com.environmental.lake.fragment.Fragment_mine;

import java.util.List;

/**
 * Created by lake on 2016/8/22.
 */
public class MainPagerAdapter extends FragmentPagerAdapter{
    private List<String> mTabList;
    public MainPagerAdapter(FragmentManager fm,List<String> tabList) {
        super(fm);
        mTabList=tabList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment_main();
            case 1:
                return new Fragment_mine();
            default:
                return new Fragment_main();
        }
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabList.get(position);
    }
}
