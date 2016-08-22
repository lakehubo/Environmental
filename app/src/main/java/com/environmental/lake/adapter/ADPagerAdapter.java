package com.environmental.lake.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.environmental.lake.fragment.Fragment_ad;

/**
 * Created by lake on 2016/8/23.
 */
public class ADPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    public ADPagerAdapter(FragmentManager fm, ViewPager viewPager) {
        super(fm);
        this.mViewPager = viewPager;
    }

    @Override
    public Fragment getItem(int position) {
        return Fragment_ad.newInstance(position + 1);

    }

    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("getPageTitle", String.valueOf(position));
        return " ";
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("onPageScrolled", String.valueOf(position));
    }

    @Override
    public void onPageSelected(int position) {
        Log.e("onPageSelected", String.valueOf(position));
        if (getCount() > 1) { //多于1，才会循环跳转
            if (position < 1) { //首位之前，跳转到末尾（N）
                position = 4; //注意这里是mList，而不是mViews
                mViewPager.setCurrentItem(position, false);
            } else if (position > 4) { //末位之后，跳转到首位（1）
                mViewPager.setCurrentItem(1, false); //false:不显示跳转过程的动画
                position = 1;
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
