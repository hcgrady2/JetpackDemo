package com.hc.jetpackdemo.ui.notifications;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

//    public NotificationsViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is notifications fragment");
//    }


    SavedStateHandle handle;
    public NotificationsViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);

        this.handle = handle;


        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");





    }

    public LiveData<String> getText() {
        return mText;
    }
}