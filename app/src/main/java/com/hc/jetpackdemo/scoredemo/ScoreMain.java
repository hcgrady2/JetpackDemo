package com.hc.jetpackdemo.scoredemo;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.hc.jetpackdemo.R;
import com.hc.jetpackdemo.databinding.FragmentCoreHomeBinding;

public class ScoreMain extends AppCompatActivity {
    ScoreViewModel scoreViewModel;

    FragmentCoreHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.fragment_core_home);
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setScoreModel(scoreViewModel);

    }
}
