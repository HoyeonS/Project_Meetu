package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatusActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Button BtnFindFriend = findViewById(R.id.btn_find_friends);
        Button BtnDeveloperContact = findViewById(R.id.btn_contact_developer);

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