package com.environmental.lake.environmental;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.environmental.lake.asynctask.GetWeatherAsyncTask;
import com.environmental.lake.util.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorBlack);//通知栏所需颜色
        }
        setContentView(R.layout.activity_main);
        mCityName=(TextView)findViewById(R.id.weather_cityname);
        weather_datetime=(TextView)findViewById(R.id.weather_datetime);
        img_weatheriamg=(ImageView) findViewById(R.id.img_weatheriamg);
        weather_temp=(TextView)findViewById(R.id.weather_temp);
        weather_imgName=(TextView)findViewById(R.id.weather_imgName);
        weather_tempall=(TextView)findViewById(R.id.weather_tempall);
        weather_today=(TextView)findViewById(R.id.weather_today);
        weather_imag_today=(ImageView) findViewById(R.id.weather_imag_today);
        weather_today_temp=(TextView)findViewById(R.id.weather_today_temp);
        weather_tomorrow=(TextView)findViewById(R.id.weather_tomorrow);
        weather_imag_tomorrow=(ImageView) findViewById(R.id.weather_imag_tomorrow);
        weather_tomorrow_temp=(TextView)findViewById(R.id.weather_tomorrow_temp);
        weather_after_tomorrow=(TextView)findViewById(R.id.weather_after_tomorrow);
        weather_imag_after_tomorrow=(ImageView) findViewById(R.id.weather_imag_after_tomorrow);
        weather_after_tomorrow_temp=(TextView)findViewById(R.id.weather_after_tomorrow_temp);
        lnlay_weather_bg=(LinearLayout)findViewById(R.id.lnlay_weather_bg);
        img_line_weather=(ImageView)findViewById(R.id.img_line_weather);

        //获取天气
        GetWeatherAsyncTask getWeatherAsyncTask=new GetWeatherAsyncTask(mCityName,weather_datetime,
                img_weatheriamg,weather_temp,weather_imgName,weather_tempall,weather_today,weather_imag_today
        ,weather_today_temp,weather_tomorrow,weather_imag_tomorrow,weather_tomorrow_temp,weather_after_tomorrow
        ,weather_imag_after_tomorrow,weather_after_tomorrow_temp,lnlay_weather_bg,img_line_weather);

        getWeatherAsyncTask.execute((Void)null);


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
}
