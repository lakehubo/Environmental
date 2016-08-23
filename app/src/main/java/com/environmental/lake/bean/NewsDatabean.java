package com.environmental.lake.bean;

/**
 * Created by lake on 2016/8/24.
 */
public class NewsDatabean {
    public int newsid;
    public int count;
    public int[] imageview;
    public String[] newstitles;

    public NewsDatabean(int count, int[] imageview, String[] newstitles) {
        this.count = count;
        this.imageview = imageview;
        this.newstitles = newstitles;
    }

    public int getCount() {
        return count;
    }

    public int[] getImageview() {
        return imageview;
    }

    public String[] getNewstitles() {
        return newstitles;
    }
}
