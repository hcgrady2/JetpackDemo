package com.hc.jetpackdemo.ui.notifications;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Created by hcw  on 2020/4/20
 * 类描述：
 * all rights reserved
 */


public class MyChronometer extends Chronometer implements LifecycleObserver {

    private long elapsedTime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter(){
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private  void resumeMeter(){
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }

}
