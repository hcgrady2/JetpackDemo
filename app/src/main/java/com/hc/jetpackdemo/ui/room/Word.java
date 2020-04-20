package com.hc.jetpackdemo.ui.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by hcw  on 2020/4/20
 * 类描述：
 * all rights reserved
 */
@Entity
public class Word {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name =  "en_world")
    private String world;

    @ColumnInfo(name = "ch_meaning")
    private String chinesetMeaning;


    public Word(String world, String chinesetMeaning) {
        this.world = world;
        this.chinesetMeaning = chinesetMeaning;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public String getChinesetMeaning() {
        return chinesetMeaning;
    }

    public void setChinesetMeaning(String chinesetMeaning) {
        this.chinesetMeaning = chinesetMeaning;
    }

}
