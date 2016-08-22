package com.environmental.lake.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.environmental.lake.fragment.Fragment_ad;

import java.util.List;

/**
 * Created by lake on 2016/8/23.
 */
public class ADPagerAdapter extends PagerAdapter {
    private List<View> mList;
    private View mView;
    @Override//具体作用，我也不是很清楚，后面理解后会补上
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override//总共图片数
    public int getCount() {
        return mList.size();
    }
    //在这里我们传入List<>里的图片列表
    public ADPagerAdapter (List<View> list) {
        super();
        this.mList=list;
    }

    @Override//这里加载图片
    public Object instantiateItem(ViewGroup container, int position) {
        if (position<mList.size()-1){
            (container).addView(mList.get(position),0);
            return mList.get(position);
        }
        return null;
    }

    @Override//这里销毁图片
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(position<mList.size()-1){
            (container).removeView(mList.get(position));
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("getPageTitle",String.valueOf(position));
        return " ";
    }

}
