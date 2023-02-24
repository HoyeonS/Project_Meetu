package com.example.project_meetu;

import android.app.Application;

public class UserID extends Application {

    String client_id; // client ID for transfering

    public static UserID instance = new UserID(); //instance information

    public static UserID getInstance(){
        return instance;
    } //generate instance

    public void onCreate(){ //create section for overiding
        super.onCreate();
        instance = this;
    }

    public UserID() { //default options only for developer
        client_id = "ERROR";
    }

    public UserID(String input_id){ //user-options
        client_id = input_id;
    }

    public void setUserID(String input_id){
        client_id = input_id;
    }
    public String getUserId(){
        return client_id;
    }
}
