package com.environmental.lake.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.environmental.lake.environmental.R;

/**
 * Created by lake on 2016/8/23.
 */
public class AddViewToNewsItem {
    public int mImageView;
    public String mTextView;
    private Context mContext;
    public AddViewToNewsItem(Context context,int mImageView, String mTextView) {
        this.mImageView = mImageView;
        this.mTextView = mTextView;
        this.mContext=context;
    }
    public View getNewsView(){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v=inflater.inflate(R.layout.news_item_item,null);
        ImageView imageView=(ImageView)v.findViewById(R.id.news_item_item_imge);
        TextView textView=(TextView)v.findViewById(R.id.news_item_item_tv);
        imageView.setBackgroundResource(mImageView);
        textView.setText(mTextView);
        return v;
    }
}
