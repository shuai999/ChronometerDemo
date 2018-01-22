package com.chronometer.demo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Email 2185134304@qq.com
 * Created by JackChen on 2018/1/20.
 * Version 1.0
 * Description: Chronometer 计时器 ：
 *              1.从0开始计时
 *              2.从自己想要的时间开始计时
 */
public class MainActivity extends AppCompatActivity {

    Chronometer ch ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=(Chronometer)findViewById(R.id.chronometer);
        //1.从0开始计时
//        //设置开始计时时间
//        ch.setBase(SystemClock.elapsedRealtime() - 5*1000);
//        //启动计时器
//        ch.start();



//        2.从自己想要的时间开始计时
        String currentDate = getStringDate();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "2018-01-22 11:00:20" ;

        try {
            Date d1 = df.parse(date);
            Date d2 = df.parse(currentDate);
            //Date   d2 = new   Date(System.currentTimeMillis());//你也可以获取当前时间
            long diff = d2.getTime() - d1.getTime();//这样得到的差值是微秒级别
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
            long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);

            //时间差
            int timeDiff = new Long(days).intValue()*24*60 + new Long(hours).intValue()*60 + new Long(minutes).intValue() ;
            Log.d("timeDiff" , timeDiff+"======"+diff+"=="+days+"=="+hours+"=="+minutes+"=="+minutes*60) ;

            //timeDiff为分 timeDiff*60就是需要的秒

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


}
