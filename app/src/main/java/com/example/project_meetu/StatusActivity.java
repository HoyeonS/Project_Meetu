package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;

public class StatusActivity extends AppCompatActivity {


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

        BtnFindFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StatusActivity.this, FriendActivity.class);
                startActivity(intent);
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

}