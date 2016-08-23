package com.environmental.lake.environmental;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class NewsActivity extends AppCompatActivity {
    private ListView news_listview;
    private static final String TAG = "NewsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        news_listview=(ListView)findViewById(R.id.news_listview);

    }
}
