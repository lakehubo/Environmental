package com.environmental.lake.util;

import com.environmental.lake.environmental.R;

/**
 * Created by lake on 2016/8/19.
 */
public class WeatherImage {
    public int getWeatherImge(String s){
        if (s==null){
            return 0;
        }
        switch (s){
            case "多云":
                return R.mipmap.cloudy;
            case "晴":
                return R.mipmap.sun;
            case "阴":
                return R.mipmap.shade;
            case "阵雨":
                return R.mipmap.heavy_rain;
            case "雷阵雨":
                return R.mipmap.leizhenyu;
            case "雷阵雨伴有冰雹":
                return R.mipmap.leizhenyu;
            case "雨夹雪":
                return R.mipmap.yujiaxue;
            case "小雨":
                return R.mipmap.small_rain;
            case "中雨":
                return R.mipmap.minel_rain;
            case "大雨":
                return R.mipmap.heavy_rain;
            case "暴雨":
                return R.mipmap.rainstorm;
            case "大暴雨":
                return R.mipmap.heavy_rainstorm;
            case "特大暴雨":
                return R.mipmap.very_heavy_rainstorm;
            case "阵雪":
                return R.mipmap.small_snow;
            case "小雪":
                return R.mipmap.small_snow;
            case "中雪":
                return R.mipmap.minel_snow;
            case "大雪":
                return R.mipmap.heavy_snow;
            case "暴雪":
                return R.mipmap.snowstorm;
            case "雾":
                return R.mipmap.fog;
            case "冻雨":
                return R.mipmap.dongyu;
            case "沙尘暴":
                return R.mipmap.shachenbao;
            case "小到中雨":
                return R.mipmap.small_rain;
            case "中到大雨":
                return R.mipmap.minel_rain;
            case "大到暴雨":
                return R.mipmap.heavy_rain;
            case "暴雨到大暴雨":
                return R.mipmap.heavy_rainstorm;
            case "小到中雪":
                return R.mipmap.small_snow;
            case "大到暴雪":
                return R.mipmap.heavy_snow;
            case "浮尘":
                return R.mipmap.fuchen;
            case "扬沙":
                return R.mipmap.yangsha;
            case "强沙尘暴":
                return R.mipmap.shachenbao;
            case "霾":
                return R.mipmap.mai;
            case "无":
                return R.mipmap.sun;
            default:
                return R.mipmap.cloudy;

        }
    }
}
