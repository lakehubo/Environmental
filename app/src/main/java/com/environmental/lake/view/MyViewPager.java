package com.environmental.lake.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by lake on 2016/8/23.
 */
public class MyViewPager extends ViewPager {

               private boolean isPagingEnabled = true;

               public MyViewPager(Context context) {
               super(context);
           }

       public MyViewPager(Context context, AttributeSet attrs) {
                super(context, attrs);
           }

               @Override
       public boolean onTouchEvent(MotionEvent event) {
               return this.isPagingEnabled && super.onTouchEvent(event);
            }

               @Override
       public boolean onInterceptTouchEvent(MotionEvent event) {
                return this.isPagingEnabled && super.onInterceptTouchEvent(event);
           }

               public void setPagingEnabled(boolean b) {
               this.isPagingEnabled = b;
           }}

