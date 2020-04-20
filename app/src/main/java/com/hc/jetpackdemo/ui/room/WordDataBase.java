package com.hc.jetpackdemo.ui.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by hcw  on 2020/4/20
 * 类描述：
 * all rights reserved
 */




@Database(entities =  {Word.class},version = 1,exportSchema =  false)
public abstract  class WordDataBase extends RoomDatabase {
    public abstract WordDao getWorldDao();

}
