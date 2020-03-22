package com.hc.jetpackdemo.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("v2.0.0.0");
    }

    public LiveData<String> getText() {
        return mText;
    }


    public void goScoreDemo(){

    }

}