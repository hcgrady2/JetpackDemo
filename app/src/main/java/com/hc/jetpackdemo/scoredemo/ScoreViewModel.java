package com.hc.jetpackdemo.scoredemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    private static final String TAG = "ScoreViewModel";
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;


    private final  String HANDLE_KEY = "handle_key";

    private SavedStateHandle handle;




    //添加 viewmodel-savedstate 依赖之后，可以使用这个构造方法
    public ScoreViewModel(SavedStateHandle handle) {
        this.handle = handle;


    }



    //undo
    private  int aBack,bBack;

    public MutableLiveData<Integer> getaTeamScore(){
        Log.i(TAG, "getaTeamScore: ");
        if(aTeamScore == null){
            aTeamScore = new MutableLiveData<>();
            aTeamScore.setValue(0);
        }

        return  aTeamScore;
    }


    public MutableLiveData<Integer> getbTeamScore(){
        Log.i(TAG, "getbTeamScore: ");
//        if( bTeamScore == null){
//            bTeamScore = new MutableLiveData<>();
//        }




        if(!handle.contains(HANDLE_KEY)){
            //程序第一次被加载的时候
            handle.set(HANDLE_KEY,0);
        }

      bTeamScore = handle.getLiveData(HANDLE_KEY);

        return  bTeamScore;


    }

    public void aTeamAdd(int s){
        Log.i(TAG, "aTeamAdd: ");
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        aTeamScore.setValue(aTeamScore.getValue() + s);
    }

    public void bTeamAdd(int s){
        Log.i(TAG, "bTeamAdd: ");
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();
        bTeamScore.setValue(bTeamScore.getValue() + s);
    }

    public void reset(){
        Log.i(TAG, "reset: ");
        aBack = aTeamScore.getValue();
        bBack = bTeamScore.getValue();

        aTeamScore.setValue(0);
        bTeamScore.setValue(0);
    }

    public void undo(){
        Log.i(TAG, "undo: ");
        aTeamScore.setValue(aBack);
        bTeamScore.setValue(bBack);
    }






}
