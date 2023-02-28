package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Button StartRegBtn = findViewById(R.id.StartPrfBtn);

        StartRegBtn.setOnClickListener(view -> {

            EditText edit_name = findViewById(R.id.inputName);
            Student.getInstance().setName(edit_name.getText().toString());
            EditText edit_ID = findViewById(R.id.inputID);
            Student.getInstance().setId(edit_ID.getText().toString());
            Intent intent = new Intent(NameActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

    }
}