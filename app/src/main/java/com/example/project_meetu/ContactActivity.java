package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button BtnContactActivity = findViewById(R.id.btn_contact_activity);
        BtnContactActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactActivity.this,StatusActivity.class);
                startActivity(intent);
                /**
                 * Retrofit interface @POST("./signup)
                 * INPUT: Student information from instance
                 * OUTPUT: Validality
                 */
                // HelloWorld

            }
        });
    }
}