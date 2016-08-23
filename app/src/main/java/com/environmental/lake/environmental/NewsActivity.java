package com.environmental.lake.environmental;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.environmental.lake.adapter.NewsitemAdapter;
import com.environmental.lake.bean.NewsDatabean;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private ListView news_listview;
    private List<NewsDatabean> newsDatabeanList;
    private static final String TAG = "NewsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        news_listview=(ListView)findViewById(R.id.news_listview);
        initdata();
        NewsitemAdapter newsitemAdapter=new NewsitemAdapter(this,newsDatabeanList);
        news_listview.setAdapter(newsitemAdapter);
    }
    private void initdata(){
        newsDatabeanList=new ArrayList<>();
        int[] imageViews=new int[2];
        String[] strings=new String[2];
        imageViews[0]=R.color.colorAccent;
        strings[0]="test";
        imageViews[1]=R.color.color_blue;
        strings[1]="test2";
        newsDatabeanList.add(new NewsDatabean(1,imageViews,strings));
    }
}
