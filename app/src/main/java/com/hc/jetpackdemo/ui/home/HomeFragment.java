package com.hc.jetpackdemo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hc.jetpackdemo.R;
import com.hc.jetpackdemo.databinding.FragmentHomeBinding;
import com.hc.jetpackdemo.scoredemo.ScoreMain;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);



        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
       // View root = inflater.inflate(R.layout.fragment_home, container, false);

        binding.setHomeData(homeViewModel);
        binding.setLifecycleOwner(this);

        View root = binding.getRoot();

        binding.scoreMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ScoreMain.class));
            }
        });

        return root;
    }
}