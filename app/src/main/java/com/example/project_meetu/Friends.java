package com.example.project_meetu;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Friends extends Application {

    List<String> friends_id = new ArrayList<>();

    public static Friends instance = new Friends();

    public static Friends getInstance() { return  instance; }

    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    public void setFriends_id(List<String> friends_id){ this.friends_id = friends_id;}
    public List<String> getFriends_id(){return this.friends_id;}

}
