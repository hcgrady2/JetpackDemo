package com.hc.jetpackdemo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.hc.jetpackdemo.R;
import com.hc.jetpackdemo.databinding.LayoutUiWidgetBinding;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    LayoutUiWidgetBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //ViewModel 和 当前控制器的绑定
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        binding =  DataBindingUtil.inflate(inflater, R.layout.layout_ui_widget,container,false);

        binding.setData(dashboardViewModel);
        binding.setLifecycleOwner(this);
        View root = binding.getRoot();//inflater.inflate(R.layout.test_fragment_idcard, container, false);

        return root;
    }
}