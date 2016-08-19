package com.environmental.lake.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.environmental.lake.bean.WeatherBean;
import com.environmental.lake.environmental.R;
import com.environmental.lake.util.WeatherImage;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by lake on 2016/8/19.
 */
public class GetWeatherAsyncTask extends AsyncTask<Void, Void, WeatherBean> {
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

    private String httpUrl = "http://apis.baidu.com/apistore/weatherservice/recentweathers";
    private String httpUrlAll = "http://apis.baidu.com/heweather/weather/free";//全能
    private String httpArg = "cityname=%E5%8C%85%E5%A4%B4&cityid=101080201";//包头

    public GetWeatherAsyncTask(TextView mCityName) {
        this.mCityName = mCityName;
    }

    public GetWeatherAsyncTask(TextView mCityName, TextView weather_datetime,
                               ImageView img_weatheriamg, TextView weather_temp,
                               TextView weather_imgName, TextView weather_tempall,
                               TextView weather_today, ImageView weather_imag_today,
                               TextView weather_today_temp, TextView weather_tomorrow,
                               ImageView weather_imag_tomorrow, TextView weather_tomorrow_temp,
                               TextView weather_after_tomorrow, ImageView weather_imag_after_tomorrow,
                               TextView weather_after_tomorrow_temp, LinearLayout linearLayout,
                               ImageView imageView) {
        this.mCityName = mCityName;
        this.weather_datetime = weather_datetime;
        this.img_weatheriamg = img_weatheriamg;
        this.weather_temp = weather_temp;
        this.weather_imgName = weather_imgName;
        this.weather_tempall = weather_tempall;
        this.weather_today = weather_today;
        this.weather_imag_today = weather_imag_today;
        this.weather_today_temp = weather_today_temp;
        this.weather_tomorrow = weather_tomorrow;
        this.weather_imag_tomorrow = weather_imag_tomorrow;
        this.weather_tomorrow_temp = weather_tomorrow_temp;
        this.weather_after_tomorrow = weather_after_tomorrow;
        this.weather_imag_after_tomorrow = weather_imag_after_tomorrow;
        this.weather_after_tomorrow_temp = weather_after_tomorrow_temp;
        this.lnlay_weather_bg = linearLayout;
        this.img_line_weather = imageView;
    }

    public GetWeatherAsyncTask(String httpArg, TextView mCityName) {
        this.httpArg = httpArg;
        this.mCityName = mCityName;
    }

    @Override
    protected WeatherBean doInBackground(Void... voids) {

        String jsonResult = request(httpUrl, httpArg);
        //System.out.println(jsonResult);
        JSONObject jsonObject;
        WeatherBean weatherBean = null;
        try {
            weatherBean=new WeatherBean();
            jsonObject = new JSONObject(jsonResult);
            weatherBean.paresJsonAll(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Log.e("doInBackground: ",weatherBean.toString());
        return weatherBean;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(WeatherBean weatherBean) {
        super.onPostExecute(weatherBean);
        int erNum = -1;
        String errMsg="";
        if(weatherBean!=null){
            erNum = weatherBean.getErrNum();
            errMsg=weatherBean.getErrMsg();
            if(errMsg==null){
                erNum=-1;
            }
            WeatherImage weatherImage = new WeatherImage();
            if (erNum == 0&&errMsg.equals("success")) {
                mCityName.setText(weatherBean.getCity());
                weather_datetime.setText(weatherBean.getData());
                img_weatheriamg.setBackgroundResource(weatherImage.getWeatherImge(weatherBean.getWeather()));
                weather_temp.setText(weatherBean.getTemp());
                weather_imgName.setText(weatherBean.getWeather());
                weather_tempall.setText(weatherBean.getH_temp() + "-" + weatherBean.getL_temp());
                weather_today.setText(weatherBean.getForecast_week());
                weather_imag_today.setBackgroundResource(weatherImage.getWeatherImge(weatherBean.getForecast_type()));
                weather_today_temp.setText(weatherBean.getForecast_hightemp() + "-" + weatherBean.getForecast_lowtemp());
                weather_tomorrow.setText(weatherBean.getForecast_week1());
                weather_imag_tomorrow.setBackgroundResource(weatherImage.getWeatherImge(weatherBean.getForecast_type1()));
                weather_tomorrow_temp.setText(weatherBean.getForecast_hightemp1() + "-" + weatherBean.getForecast_lowtemp1());
                weather_after_tomorrow.setText(weatherBean.getForecast_week2());
                weather_imag_after_tomorrow.setBackgroundResource(weatherImage.getWeatherImge(weatherBean.getForecast_type2()));
                weather_after_tomorrow_temp.setText(weatherBean.getForecast_hightemp2() + "-" + weatherBean.getForecast_lowtemp2());
            } else {
                lnlay_weather_bg.setVisibility(View.GONE);
                img_line_weather.setVisibility(View.GONE);
                mCityName.setText(R.string.weather_error);
            }
        }else{
            lnlay_weather_bg.setVisibility(View.GONE);
            img_line_weather.setVisibility(View.GONE);
            mCityName.setText(R.string.weather_error);
        }
    }

    @Override
    protected void onCancelled(WeatherBean s) {
        super.onCancelled(s);
    }

    /**
     * @param :请求接口
     * @param httpArg :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey", "cd22691dce2b46d59426f539f2bb6165");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
