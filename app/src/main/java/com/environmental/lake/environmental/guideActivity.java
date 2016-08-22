package com.environmental.lake.environmental;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.environmental.lake.fragment.Fragment_main;
import com.environmental.lake.util.SystemBarTintManager;

public class GuideActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private FrameLayout fm_btn_skip;
    public FrameLayout fm_btn_enter;
    private ViewPager mViewPager;
    private ImageView img_guide_f_dont;
    private ImageView img_guide_s_dont;
    private ImageView img_guide_t_dont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorBlack);//通知栏所需颜色
        }
        setContentView(R.layout.activity_guide);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        fm_btn_enter=(FrameLayout)findViewById(R.id.fm_enter_app);
        fm_btn_skip=(FrameLayout)findViewById(R.id.fm_skip);
        img_guide_f_dont=(ImageView)findViewById(R.id.img_guide_f_dont);
        img_guide_s_dont=(ImageView)findViewById(R.id.img_guide_s_dont);
        img_guide_t_dont=(ImageView)findViewById(R.id.img_guide_t_dont);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        img_guide_f_dont.setBackgroundResource(R.color.colorAccent);
                        img_guide_s_dont.setBackgroundResource(R.color.colorWhite);
                        img_guide_t_dont.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 1:
                        img_guide_f_dont.setBackgroundResource(R.color.colorWhite);
                        img_guide_s_dont.setBackgroundResource(R.color.colorAccent);
                        img_guide_t_dont.setBackgroundResource(R.color.colorWhite);
                        break;
                    case 2:
                        img_guide_f_dont.setBackgroundResource(R.color.colorWhite);
                        img_guide_s_dont.setBackgroundResource(R.color.colorWhite);
                        img_guide_t_dont.setBackgroundResource(R.color.colorAccent);
                        fm_btn_enter.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fm_btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转主页
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        fm_btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳过
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
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
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_guide, container, false);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.img_guide);
            int pagernum=getArguments().getInt(ARG_SECTION_NUMBER);
            switch (pagernum){
                case 1:
                    imageView.setBackgroundResource(R.mipmap.guide_f);
                    break;
                case 2:
                    imageView.setBackgroundResource(R.mipmap.guide_s);
                    break;
                case 3:
                    imageView.setBackgroundResource(R.mipmap.guide_t);
                    break;
                default:
                    break;
            }
            return rootView;
        }
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
