package com.hc.jetpackdemo.ui.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by hcw  on 2020/4/20
 * 类描述：
 * all rights reserved
 */

//database access object
@Dao
public interface WordDao {

    //可以传递一个，也可以传递多个参数，并且可以有返回值
    @Insert
    void insertWords(Word... words);


    @Update
    void updateWorld(Word... words);

    @Delete
    void deleteWorld(Word... words);


    @Query("DELETE FROM WORD")
    void deleteAllWorlds();


    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    List<Word> getAllWorlds();




}
