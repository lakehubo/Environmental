package com.environmental.lake.fragment;

import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.environmental.lake.adapter.ADPagerAdapter;
import com.environmental.lake.adapter.PagerChangeListener;
import com.environmental.lake.asynctask.GetWeatherAsyncTask;
import com.environmental.lake.environmental.NewsActivity;
import com.environmental.lake.environmental.R;
import com.environmental.lake.environmental.SearchActivity;
import com.environmental.lake.environmental.WebActivity;

import java.util.ArrayList;
import java.util.List;

public class Fragment_main extends Fragment implements View.OnClickListener {
    private final static String TAG = "Fragment_main";
    private TextView mCityName;
    private TextView weather_datetime;
    private ImageView img_weatheriamg;
    private TextView weather_temp;
    private TextView weather_imgName;
    private TextView weather_tempall;
    private TextView weather_today;
    private ImageView weather_imag_today;
    private TextView weather_today_temp;
    private TextView weather_tomorrow;
    private ImageView weather_imag_tomorrow;
    private TextView weather_tomorrow_temp;
    private TextView weather_after_tomorrow;
    private ImageView weather_imag_after_tomorrow;
    private TextView weather_after_tomorrow_temp;
    private LinearLayout lnlay_weather_bg;
    private ImageView img_line_weather;
    private LinearLayout LnLay_search;
    private ViewPager main_viewpager_ad;
    public boolean isStop = false;
    public Thread mThread = null;
    private LinearLayout lnlay_news;
    private LinearLayout Lnlay_web_site;
    private LinearLayout Lnlay_ask_answer;
    private LinearLayout Lnlay_download_files;
    private LinearLayout Lnlay_activation_record;
    private LinearLayout Lnlay_envir_policies;
    private LinearLayout Lnlay_pirze_competition;
    private LinearLayout Lnlay_science_highlights;
    private LinearLayout Lnlay_funny_games;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mThread == null) {
            mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!isStop) {
                        Log.e(TAG, "run:isStop= " + isStop);
                        try {
                            Thread.sleep(4000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (main_viewpager_ad.getCurrentItem() < 6) {
                                        main_viewpager_ad.setCurrentItem(main_viewpager_ad.getCurrentItem() + 1);
                                    } else if (main_viewpager_ad.getCurrentItem() == 6) {
                                        main_viewpager_ad.setCurrentItem(1, false);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            mThread.start();
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);
        initviews(rootview);
        //获取天气
        GetWeatherAsyncTask getWeatherAsyncTask = new GetWeatherAsyncTask(mCityName, weather_datetime,
                img_weatheriamg, weather_temp, weather_imgName, weather_tempall, weather_today, weather_imag_today
                , weather_today_temp, weather_tomorrow, weather_imag_tomorrow, weather_tomorrow_temp, weather_after_tomorrow
                , weather_imag_after_tomorrow, weather_after_tomorrow_temp, lnlay_weather_bg, img_line_weather);

        getWeatherAsyncTask.execute((Void) null);
        isStop = false;
        List<View> pagerViews = inintviews();
        main_viewpager_ad = (ViewPager) rootview.findViewById(R.id.main_viewpager_ad);
        ADPagerAdapter adPagerAdapter = new ADPagerAdapter(pagerViews);
        main_viewpager_ad.setAdapter(adPagerAdapter);

        //这里实现手动滑动时候的循环切换
        main_viewpager_ad.addOnPageChangeListener(new PagerChangeListener(rootview, main_viewpager_ad));

        return rootview;
    }

    //这里我们new几个imageview然后放入List<>中
    public List<View> inintviews() {
        List<View> pagerViews = new ArrayList<View>();
        ImageView imageview0 = new ImageView(getActivity());
        imageview0.setBackgroundResource(R.color.colorAccent);
        pagerViews.add(imageview0);
        ImageView imageview = new ImageView(getActivity());
        imageview.setBackgroundResource(R.color.color_orange);
        pagerViews.add(imageview);
        ImageView imageview2 = new ImageView(getActivity());
        imageview2.setBackgroundResource(R.color.color_blue);
        pagerViews.add(imageview2);
        ImageView imageview3 = new ImageView(getActivity());
        imageview3.setBackgroundResource(R.color.color_green);
        pagerViews.add(imageview3);
        ImageView imageview4 = new ImageView(getActivity());
        imageview4.setBackgroundResource(R.color.colorPrimary);
        pagerViews.add(imageview4);
        ImageView imageview5 = new ImageView(getActivity());
        imageview5.setBackgroundResource(R.color.colorAccent);
        pagerViews.add(imageview5);
        ImageView imageview6 = new ImageView(getActivity());
        imageview6.setBackgroundResource(R.color.color_orange);
        pagerViews.add(imageview6);
        pagerViews.add(imageview6);
        return pagerViews;
    }

    private void initviews(View rootview) {
        mCityName = (TextView) rootview.findViewById(R.id.weather_cityname);
        weather_datetime = (TextView) rootview.findViewById(R.id.weather_datetime);
        img_weatheriamg = (ImageView) rootview.findViewById(R.id.img_weatheriamg);
        weather_temp = (TextView) rootview.findViewById(R.id.weather_temp);
        weather_imgName = (TextView) rootview.findViewById(R.id.weather_imgName);
        weather_tempall = (TextView) rootview.findViewById(R.id.weather_tempall);
        weather_today = (TextView) rootview.findViewById(R.id.weather_today);
        weather_imag_today = (ImageView) rootview.findViewById(R.id.weather_imag_today);
        weather_today_temp = (TextView) rootview.findViewById(R.id.weather_today_temp);
        weather_tomorrow = (TextView) rootview.findViewById(R.id.weather_tomorrow);
        weather_imag_tomorrow = (ImageView) rootview.findViewById(R.id.weather_imag_tomorrow);
        weather_tomorrow_temp = (TextView) rootview.findViewById(R.id.weather_tomorrow_temp);
        weather_after_tomorrow = (TextView) rootview.findViewById(R.id.weather_after_tomorrow);
        weather_imag_after_tomorrow = (ImageView) rootview.findViewById(R.id.weather_imag_after_tomorrow);
        weather_after_tomorrow_temp = (TextView) rootview.findViewById(R.id.weather_after_tomorrow_temp);
        lnlay_weather_bg = (LinearLayout) rootview.findViewById(R.id.lnlay_weather_bg);
        img_line_weather = (ImageView) rootview.findViewById(R.id.img_line_weather);
        main_viewpager_ad = (ViewPager) rootview.findViewById(R.id.main_viewpager_ad);
        LnLay_search = (LinearLayout) rootview.findViewById(R.id.LnLay_search);
        lnlay_news = (LinearLayout) rootview.findViewById(R.id.lnlay_news);
        Lnlay_web_site = (LinearLayout) rootview.findViewById(R.id.Lnlay_web_site);
        Lnlay_ask_answer = (LinearLayout) rootview.findViewById(R.id.Lnlay_ask_answer);
        Lnlay_download_files = (LinearLayout) rootview.findViewById(R.id.Lnlay_download_files);
        Lnlay_activation_record = (LinearLayout) rootview.findViewById(R.id.Lnlay_activation_record);
        Lnlay_envir_policies = (LinearLayout) rootview.findViewById(R.id.Lnlay_envir_policies);
        Lnlay_pirze_competition = (LinearLayout) rootview.findViewById(R.id.Lnlay_pirze_competition);
        Lnlay_science_highlights = (LinearLayout) rootview.findViewById(R.id.Lnlay_science_highlights);
        Lnlay_funny_games = (LinearLayout) rootview.findViewById(R.id.Lnlay_funny_games);


        LnLay_search.setOnClickListener(this);
        lnlay_news.setOnClickListener(this);
        Lnlay_web_site.setOnClickListener(this);
        Lnlay_ask_answer.setOnClickListener(this);
        Lnlay_download_files.setOnClickListener(this);
        Lnlay_activation_record.setOnClickListener(this);
        Lnlay_envir_policies.setOnClickListener(this);
        Lnlay_pirze_competition.setOnClickListener(this);
        Lnlay_science_highlights.setOnClickListener(this);
        Lnlay_funny_games.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.LnLay_search:
                Intent intent = new Intent();
                intent.setClass(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.lnlay_news:
                Intent intent1 = new Intent();
                intent1.setClass(getActivity(), NewsActivity.class);
                startActivity(intent1);
                break;

            case R.id.Lnlay_web_site:
                Intent intent2 = new Intent();
                intent2.setClass(getActivity(), WebActivity.class);
                startActivity(intent2);
                break;
            case R.id.Lnlay_ask_answer:

                break;
            case R.id.Lnlay_download_files:

                break;
            case R.id.Lnlay_activation_record:

                break;
            case R.id.Lnlay_envir_policies:

                break;
            case R.id.Lnlay_pirze_competition:

                break;
            case R.id.Lnlay_science_highlights:

                break;
            case R.id.Lnlay_funny_games:

                break;

            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isStop = true;
    }
}
