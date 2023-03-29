package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
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

public class FriendActivity extends AppCompatActivity{

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        List<Button> btnList = new ArrayList<>();

        Button BtnFriend0 = findViewById(R.id.btn_friend0);
        Button BtnFriend1 = findViewById(R.id.btn_friend1);
        Button BtnFriend2 = findViewById(R.id.btn_friend2);
        Button BtnFriend3 = findViewById(R.id.btn_friend3);
        Button BtnFriend4 = findViewById(R.id.btn_friend4);
        Button BtnFriend5 = findViewById(R.id.btn_friend5);
        Button BtnFriend6 = findViewById(R.id.btn_friend6);
        Button BtnFriend7 = findViewById(R.id.btn_friend7);
        Button BtnFriend8 = findViewById(R.id.btn_friend8);
        Button BtnFriend9 = findViewById(R.id.btn_friend9);
        btnList.add(BtnFriend0);
        btnList.add(BtnFriend1);
        btnList.add(BtnFriend2);
        btnList.add(BtnFriend3);
        btnList.add(BtnFriend4);
        btnList.add(BtnFriend5);
        btnList.add(BtnFriend6);
        btnList.add(BtnFriend7);
        btnList.add(BtnFriend8);
        btnList.add(BtnFriend9);

        for(int i = 0; i < 10; i++){
            int index = i;
            btnList.get(index).setOnClickListener(view -> {
                Intent intent = new Intent(FriendActivity.this,MainActivity.class);

                HashMap<String, String> map = new HashMap<>();
                map.put("id",Friends.getInstance().getFriends_id().get(index));

                Call<Student> call = retrofitInterface.executeFind(map);

                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        Student selectedStudent = response.body();
                        Student.getInstance().setName(selectedStudent.getName());
                        Student.getInstance().setId(selectedStudent.getId());
                        Student.getInstance().setProfile(selectedStudent.getProfile());
                        Student.getInstance().setIntro(selectedStudent.getIntroduction());
                        Student.getInstance().setContact(selectedStudent.getContact());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {

                    }
                });
            });
        }

//        BtnFriend1.setOnClickListener( view -> {
//            Intent intent = new Intent(FriendProfile.this,MainActivity.class);
//
//            HashMap<String, String> map = new HashMap<>();
//            map.put("id",Friends.getInstance().getFriends_id().get(0));
//
//            Call<Student> call = retrofitInterface.executeFind(map);
//
//            call.enqueue(new Callback<Student>() {
//                @Override
//                public void onResponse(Call<Student> call, Response<Student> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<Student> call, Throwable t) {
//
//                }
//            });
//        });

    }
}