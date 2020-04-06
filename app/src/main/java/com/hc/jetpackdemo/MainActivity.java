package com.hc.jetpackdemo;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //底部导航，使用的是 menu
        BottomNavigationView navView = findViewById(R.id.nav_view);


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //AppBarConfiguration 是管理导航的
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();


        //通过界面上的 fragment 构造一个 NavController,fragment 通过 name 指定为 NavHostFragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        //NavigationUI 将底部导航和 navController 联系到一起
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //将 BottomNavigationView 和 controller 联系到一起
        NavigationUI.setupWithNavController(navView, navController);


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}
