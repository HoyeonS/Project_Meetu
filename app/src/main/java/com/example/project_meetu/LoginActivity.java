package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button LoginBtn = findViewById(R.id.LoginBtn);


        LoginBtn.setOnClickListener(new View.OnClickListener() {

            EditText LoginEdit = (EditText)findViewById(R.id.LoginEdit);



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,StatusActivity.class);

                UserID.getInstance().setUserID(LoginEdit.getText().toString());
                /**
                 * @POST("./login")
                 * Signup signal up with user iD
                 */
                HashMap<String, String> map = new HashMap<>();
                Call<Student> call = executeLogin(map);
                map.put("student_id", UserID.getInstance().getUserId());//wisconsin ID with signal > output : student object
                startActivity(intent);
            }
        });
    }

    Call<Student> executeLogin(@Body HashMap<String, String> map){
        return null; //need-to-be-changed
    }
}