package com.hc.jetpackdemo.scoredemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    private static final String TAG = "ScoreViewModel";
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;

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
        if( bTeamScore == null){
            bTeamScore = new MutableLiveData<>();
            bTeamScore.setValue(0);
        }

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
