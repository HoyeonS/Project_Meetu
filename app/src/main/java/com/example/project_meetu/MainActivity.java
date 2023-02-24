package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register = findViewById(R.id.BtnNew);
        Button BtnAccountAccepted = findViewById(R.id.BtnAccountAccepted);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToRegister();
            }
        });

        BtnAccountAccepted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void changeToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);

        startActivity(intent);

    }

}