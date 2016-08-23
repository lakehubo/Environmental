package com.environmental.lake.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.environmental.lake.bean.NewsDatabean;
import com.environmental.lake.environmental.R;
import com.environmental.lake.util.AddViewToNewsItem;

import java.util.List;

/**
 * Created by lake on 2016/8/24.
 */
public class NewsitemAdapter extends BaseAdapter {
    private List<NewsDatabean> mList;
    private Context mContext;

    public NewsitemAdapter(Context mContext, List<NewsDatabean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        NewsDatabean newsDatabean=mList.get(i);
        int num=newsDatabean.getCount();
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater mInflater=LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.news_item, null);
            holder = new ViewHolder();
            holder.news_image_first = (ImageView) convertView.findViewById(R.id.news_image_first);
            holder.news_first_tv=(TextView)convertView.findViewById(R.id.news_first_tv);
            holder.Lnlay_news_group_layout=(LinearLayout)convertView.findViewById(R.id.Lnlay_news_group_layout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.news_image_first.setBackgroundResource(newsDatabean.getImageview()[0]);
        holder.news_first_tv.setText(newsDatabean.getNewstitles()[0]);
        if(num>1){
            for(int m=1;m<num;m++){
                AddViewToNewsItem item=new AddViewToNewsItem(mContext,newsDatabean.getImageview()[m],
                        newsDatabean.getNewstitles()[m]);
                View v=item.getNewsView();
                holder.Lnlay_news_group_layout.addView(v);
            }

        }
        return convertView;

    }

    public static class ViewHolder {
        public ImageView news_image_first;
        public TextView news_first_tv;
        public LinearLayout Lnlay_news_group_layout;

    }

}
