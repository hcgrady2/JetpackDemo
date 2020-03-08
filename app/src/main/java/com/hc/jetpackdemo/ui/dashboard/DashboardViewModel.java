package com.hc.jetpackdemo.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    //1、使用 private
    //2、通过 构造函数初始化
    //3、重写一下 setter/getter
    private MutableLiveData<String> mText;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void setText(){

        mText.setValue("通过 databanding 的方式，改变");
    }
}