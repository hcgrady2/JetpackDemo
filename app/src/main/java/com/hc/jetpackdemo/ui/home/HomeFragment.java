package com.hc.jetpackdemo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.hc.jetpackdemo.R;
import com.hc.jetpackdemo.databinding.FragmentHomeBinding;
import com.hc.jetpackdemo.scoredemo.ScoreMain;
import com.hc.jetpackdemo.ui.room.Word;
import com.hc.jetpackdemo.ui.room.WordDao;
import com.hc.jetpackdemo.ui.room.WordDataBase;

import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;

    FragmentHomeBinding binding;


    WordDataBase wordDataBase;
    WordDao wordDao;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
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

        testDB();



        insert();

        update();


        return root;
    }



    private void testDB(){
        wordDataBase = Room.databaseBuilder(getContext(),WordDataBase.class,"word_db")
                .allowMainThreadQueries()  //设置可以主线程查询（否则报错）
                .build();
        wordDao = wordDataBase.getWorldDao();

    }


    private void updateView(){
        List<Word> list = wordDao.getAllWorlds();

        for(int i = 0; i < list.size(); i ++){
            Word word = list.get(i);

            Log.i(TAG, "updateView: word:" + word.getWorld() + ",,,,meanging:  " + word.getChinesetMeaning());

        }

    }

    private void insert(){


        Word word = new Word("Hello","nihao");
        Word word2 = new Word("Hello2","nihao2");

        wordDao.insertWords(word,word2);

        Log.i(TAG, "insert: 插入");
        updateView();



    }


    private void update(){
        Word word = new Word("test","xiugai");
        word.setId(2);

        wordDao.updateWorld(word);

        updateView();


    }

    private void delete(){

       //删除所有
        wordDao.deleteAllWorlds();

        //删除一个
        Word word = new Word("t","2");
        word.setId(2);
        wordDao.deleteWorld(word);


    }











}