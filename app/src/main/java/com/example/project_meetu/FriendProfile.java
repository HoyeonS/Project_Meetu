package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);

        TextView major = (TextView) findViewById(R.id.newFriend_major);
        major.setText(Student.getInstance().getProfile()[1]);

        TextView age = (TextView) findViewById(R.id.newFriend_age);
        major.setText(Student.getInstance().getProfile()[0]);

        TextView area = (TextView) findViewById(R.id.newFriend_area);
        major.setText(Student.getInstance().getProfile()[2]);

        TextView sp1 = (TextView) findViewById(R.id.newFriend_sp1);
        major.setText(Student.getInstance().getProfile()[3]);

        TextView sp2 = (TextView) findViewById(R.id.newFriend_sp2);
        major.setText(Student.getInstance().getProfile()[4]);

        TextView food = (TextView) findViewById(R.id.newFriend_food);
        major.setText(Student.getInstance().getProfile()[5]);

        TextView lang = (TextView) findViewById(R.id.newFriend_lang);
        major.setText(Student.getInstance().getProfile()[6]);

        TextView hobby = (TextView) findViewById(R.id.newFriend_hobby);
        major.setText(Student.getInstance().getProfile()[7]);
    }
}