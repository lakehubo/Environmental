package com.environmental.lake.environmental;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.environmental.lake.adapter.MainPagerAdapter;
import com.environmental.lake.util.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainPagerAdapter mMainPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorBlack);//通知栏所需颜色
        }
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.container_main);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_main);
        tabLayout.setupWithViewPager(mViewPager);
        List<String> tabList =new ArrayList<>();
        tabList.add(getString(R.string.main_btn_shouye));
        tabList.add(getString(R.string.main_btn_mine));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(tabList.get(1)));
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),tabList);
        mViewPager.setAdapter(mMainPagerAdapter);
        tabLayout.getTabAt(0).setIcon(R.mipmap.shouye_selecte);
        tabLayout.getTabAt(1).setIcon(R.mipmap.kehu);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    tabLayout.getTabAt(0).setIcon(R.mipmap.shouye_selecte);
                    mViewPager.setCurrentItem(0);
                } else if (tab == tabLayout.getTabAt(1)) {
                    tabLayout.getTabAt(1).setIcon(R.mipmap.kehu_selecte);
                    mViewPager.setCurrentItem(1);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    tabLayout.getTabAt(0).setIcon(R.mipmap.shouye);
                } else if (tab == tabLayout.getTabAt(1)) {
                    tabLayout.getTabAt(1).setIcon(R.mipmap.kehu);
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
