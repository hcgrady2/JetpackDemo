package com.hc.jetpackdemo.scoredemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.hc.jetpackdemo.R;
import com.hc.jetpackdemo.databinding.FragmentCoreHomeBinding;

public class ScoreMain extends AppCompatActivity {
    ScoreViewModel scoreViewModel;

    FragmentCoreHomeBinding binding;

    final  static  String KEY_NUMBER = "my_number";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this,R.layout.fragment_core_home);
        //下面的方法已经过时
        //scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        scoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setScoreModel(scoreViewModel);

        if(savedInstanceState != null){
            scoreViewModel.getaTeamScore().setValue(savedInstanceState.getInt(KEY_NUMBER));
        }



        //sp 写入文件
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("NUMBER",100);
        edit.apply();//异步的，commit 是同步提交的。


        //sp 读取文件
        int x = sp.getInt("NUMBER",1);

        Log.i("SP_TAG", "onCreate: " + x);


    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NUMBER,scoreViewModel.getaTeamScore().getValue());

    }
}
