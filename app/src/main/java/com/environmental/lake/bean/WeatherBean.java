package com.environmental.lake.bean;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by lake on 2016/8/19.
 */
public class WeatherBean {
    public int errNum;//返回消息
    public String errMsg;//返回消息
    public String city;//城市名称
    public String citycode;//城市代码
    public String data;//日期
    public String time;//时间
    public String latitude;//纬度
    public String longitude;//经度
    public String weather;//天气
    public String temp;//温度
    public String l_temp;//最低温度
    public String h_temp;//最高温度
    public String WD;//风向
    public String WS;//风力
    public String sunries;//日出
    public String sunset;//日落
    public String forecast_date;
    public String forecast_week;
    public String forecast_fengxiang;
    public String forecast_fengli;
    public String forecast_hightemp;
    public String forecast_lowtemp;
    public String forecast_type;
    public String forecast_date1;
    public String forecast_week1;
    public String forecast_fengxiang1;
    public String forecast_fengli1;
    public String forecast_hightemp1;
    public String forecast_lowtemp1;
    public String forecast_type1;
    public String forecast_date2;
    public String forecast_week2;
    public String forecast_fengxiang2;
    public String forecast_fengli2;
    public String forecast_hightemp2;
    public String forecast_lowtemp2;
    public String forecast_type2;
    public String forecast_date3;
    public String forecast_week3;
    public String forecast_fengxiang3;
    public String forecast_fengli3;
    public String forecast_hightemp3;
    public String forecast_lowtemp3;
    public String forecast_type3;

    public void paresJson(JSONObject jsonObject) {
        try {
            errNum = jsonObject.getInt("errNum");
            errMsg = jsonObject.getString("errMsg");
            JSONObject retData = jsonObject.getJSONObject("retData");
            city = retData.getString("city");
            citycode = retData.getString("citycode");
            data = retData.getString("date");
            time = retData.getString("time");
            latitude = retData.getString("latitude");
            longitude = retData.getString("latitude");
            weather = retData.getString("weather");
            temp = retData.getString("temp");
            l_temp = retData.getString("l_tmp");
            h_temp = retData.getString("h_tmp");
            WD = retData.getString("WD");
            WS = retData.getString("WS");
            sunries = retData.getString("sunrise");
            sunset = retData.getString("sunset");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void paresJsonAll(JSONObject jsonObject) {
        try {
            errNum = jsonObject.getInt("errNum");
            errMsg = jsonObject.getString("errMsg");
            JSONObject retData = jsonObject.getJSONObject("retData");
            city = retData.getString("city");
            citycode = retData.getString("cityid");
            JSONObject today = retData.getJSONObject("today");
            data = today.getString("date");
            weather = today.getString("type");
            temp = today.getString("curTemp");
            l_temp = today.getString("lowtemp");
            h_temp = today.getString("hightemp");
            JSONObject forecast = retData.getJSONArray("forecast").getJSONObject(0);
            JSONObject forecast1 = retData.getJSONArray("forecast").getJSONObject(1);
            JSONObject forecast2 = retData.getJSONArray("forecast").getJSONObject(2);
            JSONObject forecast3 = retData.getJSONArray("forecast").getJSONObject(3);
            forecast_date = forecast.getString("date");
            forecast_week = forecast.getString("week");
            forecast_fengxiang = forecast.getString("fengxiang");
            forecast_fengli = forecast.getString("fengli");
            forecast_hightemp = forecast.getString("hightemp");
            forecast_lowtemp = forecast.getString("lowtemp");
            forecast_type = forecast.getString("type");
            forecast_date1 = forecast1.getString("date");
            forecast_week1 = forecast1.getString("week");
            forecast_fengxiang1 = forecast1.getString("fengxiang");
            forecast_fengli1 = forecast1.getString("fengli");
            forecast_hightemp1 = forecast1.getString("hightemp");
            forecast_lowtemp1 = forecast1.getString("lowtemp");
            forecast_type1 = forecast1.getString("type");
            forecast_date2 = forecast2.getString("date");
            forecast_week2 = forecast2.getString("week");
            forecast_fengxiang2 = forecast2.getString("fengxiang");
            forecast_fengli2 = forecast2.getString("fengli");
            forecast_hightemp2 = forecast2.getString("hightemp");
            forecast_lowtemp2 = forecast2.getString("lowtemp");
            forecast_type2 = forecast2.getString("type");
            forecast_date3 = forecast3.getString("date");
            forecast_week3 = forecast3.getString("week");
            forecast_fengxiang3 = forecast3.getString("fengxiang");
            forecast_fengli3 = forecast3.getString("fengli");
            forecast_hightemp3 = forecast3.getString("hightemp");
            forecast_lowtemp3 = forecast3.getString("lowtemp");
            forecast_type3 = forecast3.getString("type");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getForecast_date() {
        return forecast_date;
    }

    public String getForecast_week() {
        return forecast_week;
    }

    public String getForecast_fengxiang() {
        return forecast_fengxiang;
    }

    public String getForecast_fengli() {
        return forecast_fengli;
    }

    public String getForecast_hightemp() {
        return forecast_hightemp;
    }

    public String getForecast_lowtemp() {
        return forecast_lowtemp;
    }

    public String getForecast_date1() {
        return forecast_date1;
    }

    public String getForecast_type() {
        return forecast_type;
    }

    public String getForecast_week1() {
        return forecast_week1;
    }

    public String getForecast_fengxiang1() {
        return forecast_fengxiang1;
    }

    public String getForecast_fengli1() {
        return forecast_fengli1;
    }

    public String getForecast_hightemp1() {
        return forecast_hightemp1;
    }

    public String getForecast_lowtemp1() {
        return forecast_lowtemp1;
    }

    public String getForecast_type1() {
        return forecast_type1;
    }

    public String getForecast_date2() {
        return forecast_date2;
    }

    public String getForecast_week2() {
        return forecast_week2;
    }

    public String getForecast_fengxiang2() {
        return forecast_fengxiang2;
    }

    public String getForecast_fengli2() {
        return forecast_fengli2;
    }

    public String getForecast_hightemp2() {
        return forecast_hightemp2;
    }

    public String getForecast_lowtemp2() {
        return forecast_lowtemp2;
    }

    public String getForecast_type2() {
        return forecast_type2;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getCity() {
        return city;
    }

    public String getCitycode() {
        return citycode;
    }

    public String getData() {
        return data;
    }

    public String getTime() {
        return time;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getWeather() {
        return weather;
    }

    public String getL_temp() {
        return l_temp;
    }

    public String getTemp() {
        return temp;
    }

    public String getH_temp() {
        return h_temp;
    }

    public String getWD() {
        return WD;
    }

    public String getSunries() {
        return sunries;
    }

    public String getWS() {
        return WS;
    }

    public String getSunset() {
        return sunset;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "errNum=" + errNum +
                ", errMsg='" + errMsg + '\'' +
                ", city='" + city + '\'' +
                ", citycode='" + citycode + '\'' +
                ", data='" + data + '\'' +
                ", time='" + time + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", l_temp='" + l_temp + '\'' +
                ", h_temp='" + h_temp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", sunries='" + sunries + '\'' +
                ", sunset='" + sunset + '\'' +
                ", forecast_date='" + forecast_date + '\'' +
                ", forecast_week='" + forecast_week + '\'' +
                ", forecast_fengxiang='" + forecast_fengxiang + '\'' +
                ", forecast_fengli='" + forecast_fengli + '\'' +
                ", forecast_hightemp='" + forecast_hightemp + '\'' +
                ", forecast_lowtemp='" + forecast_lowtemp + '\'' +
                ", forecast_type='" + forecast_type + '\'' +
                ", forecast_date1='" + forecast_date1 + '\'' +
                ", forecast_week1='" + forecast_week1 + '\'' +
                ", forecast_fengxiang1='" + forecast_fengxiang1 + '\'' +
                ", forecast_fengli1='" + forecast_fengli1 + '\'' +
                ", forecast_hightemp1='" + forecast_hightemp1 + '\'' +
                ", forecast_lowtemp1='" + forecast_lowtemp1 + '\'' +
                ", forecast_type1='" + forecast_type1 + '\'' +
                ", forecast_date2='" + forecast_date2 + '\'' +
                ", forecast_week2='" + forecast_week2 + '\'' +
                ", forecast_fengxiang2='" + forecast_fengxiang2 + '\'' +
                ", forecast_fengli2='" + forecast_fengli2 + '\'' +
                ", forecast_hightemp2='" + forecast_hightemp2 + '\'' +
                ", forecast_lowtemp2='" + forecast_lowtemp2 + '\'' +
                ", forecast_type2='" + forecast_type2 + '\'' +
                ", forecast_date3='" + forecast_date3 + '\'' +
                ", forecast_week3='" + forecast_week3 + '\'' +
                ", forecast_fengxiang3='" + forecast_fengxiang3 + '\'' +
                ", forecast_fengli3='" + forecast_fengli3 + '\'' +
                ", forecast_hightemp3='" + forecast_hightemp3 + '\'' +
                ", forecast_lowtemp3='" + forecast_lowtemp3 + '\'' +
                ", forecast_type3='" + forecast_type3 + '\'' +
                '}';
    }
}
