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

        StartRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit_name = (EditText)findViewById(R.id.inputName);
                Student.getInstance().setName(edit_name.getText().toString());

                Intent intent = new Intent(NameActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}