package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StatusActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Button BtnFindFriend = findViewById(R.id.btn_find_friends);
        Button BtnDeveloperContact = findViewById(R.id.btn_contact_developer);

        TextView name = findViewById(R.id.et_name);
        name.setText(Student.getInstance().student_name);

        TextView age = findViewById(R.id.et_age);
        age.setText(Student.getInstance().profile_info[0]);

        TextView major = findViewById(R.id.et_major);
        major.setText(Student.getInstance().profile_info[1]);

        TextView place = findViewById(R.id.et_area);
        place.setText(Student.getInstance().profile_info[2]);

        TextView fb = findViewById(R.id.et_favorite_library_1);
        fb.setText(Student.getInstance().profile_info[3]);

        TextView food = findViewById(R.id.et_mbti);
        food.setText(Student.getInstance().profile_info[4]);

        TextView lang = findViewById(R.id.et_language);
        lang.setText(Student.getInstance().profile_info[5]);

        TextView hobby = findViewById(R.id.et_hobby);
        hobby.setText(Student.getInstance().profile_info[6]);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        BtnFindFriend.setOnClickListener(view -> {
            Intent intent = new Intent(StatusActivity.this,MainActivity.class);

            String[] c = {"major", "age", "space1", "space2", "living", "language", "food", "Hobby"};
            HashMap<String, String> map = new HashMap<>();
            List<String> beforeFriends = new ArrayList<>();

            for(int i = 0; i < 8; i++){

                map.put(c[i], Student.getInstance().profile_info[i]);

                Call<List<String>> call = retrofitInterface.executeGenerate(map);

                call.enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        if(response.code() == 200){
                            for(int j = 0; j < 10; j++){
                                beforeFriends.add(response.body().get(j));
                            }
                        }else if(response.code() == 400){
                            Toast.makeText(StatusActivity.this, "Wrong Credentials CODE # 1",
                                    Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(StatusActivity.this, "Wrong access" + response.code(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Toast.makeText(StatusActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        BtnDeveloperContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatusActivity.this, DevelopContact.class);
                startActivity(intent);
            }
        });
    }

//    private HashMap<String, String> generateList(){
//
//        HashMap<String, String> map = new HashMap<>();
//        String[] c = {"major", "age", "space1", "space2", "living", "language", "food", "Hobby"};
//        for(int i = 0; i < 8; i++){
////            while(i< 8){
////            map.put("index", i);
//            map.put(c[i], Student.getInstance().profile_info[i]);
//        }
//        return  map;
//    }

}