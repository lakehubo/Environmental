package com.environmental.lake.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.environmental.lake.environmental.R;

/**
 * Created by lake on 2016/8/23.
 */
public class PagerChangeListener implements ViewPager.OnPageChangeListener {
    private final static String TAG = "PagerChangeListener";
    boolean isScrolled = false;
    private ViewPager mViewPager;
    private View mView;

    public PagerChangeListener(View view, ViewPager viewPager) {
        super();
        this.mViewPager = viewPager;
        this.mView = view;
        mViewPager.setCurrentItem(1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.e(TAG, "onPageSelected: " + String.valueOf(position));
        ImageView image1 = (ImageView) mView.findViewById(R.id.guide1);
        ImageView image2 = (ImageView) mView.findViewById(R.id.guide2);
        ImageView image3 = (ImageView) mView.findViewById(R.id.guide3);
        ImageView image4 = (ImageView) mView.findViewById(R.id.guide4);
        ImageView image5 = (ImageView) mView.findViewById(R.id.guide5);
        //这里设置对应的导航点的颜色显示
        switch (position) {
            case 0:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                break;
            case 1:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                break;
            case 2:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                break;
            case 3:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                break;
            case 4:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                break;
            case 5:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                break;
            case 6:
                image1.setBackgroundResource(R.drawable.img_ad_reclycle_selecte);
                image2.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image3.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image4.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                image5.setBackgroundResource(R.drawable.img_ad_reclycle_bg);
                break;
            default:
                break;
        }
    }

    //这里实现手势滑动循环，看懂了这里，你就能明白是如何实现循环的
    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state) {
            case 1:// 手势滑动
                isScrolled = false;
                break;
            case 2:// 界面切换
                isScrolled = true;
                break;
            case 0:// 滑动结束
                if (mViewPager.getCurrentItem() == 0) { //首位之前，跳转到末尾（N）
                    mViewPager.setCurrentItem(5, false);
                } else if (mViewPager.getCurrentItem() == 6) { //末位之后，跳转到首位（1）
                    mViewPager.setCurrentItem(1, false); //false:不显示跳转过程的动画
                }
                break;
        }
    }

}

