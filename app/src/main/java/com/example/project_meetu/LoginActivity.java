package com.example.project_meetu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        Button LoginBtn = findViewById(R.id.LoginBtn);


        LoginBtn.setOnClickListener(new View.OnClickListener() {

            final EditText LoginEdit = findViewById(R.id.LoginEdit);



            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,StatusActivity.class);

                UserID.getInstance().setUserID(LoginEdit.getText().toString());
                HashMap<String, String> map = new HashMap<>();
                //Call<Student> call = executeLogin(map);
                map.put("student_id", UserID.getInstance().getUserId());//wisconsin ID with signal > output : student object

                Call<LoginResult> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginResult> call, @NonNull Response<LoginResult> response) {
                        //성공시 알림
                        if(response.code() == 200){
                            Toast.makeText(LoginActivity.this, "Login Successful",
                                    Toast.LENGTH_LONG).show();
                            LoginResult client = response.body();
                            Student.getInstance().setName(client.getName());
                            Student.getInstance().setId(client.getID());
                            String[] profile_info = new String[8];
                            profile_info[0] = client.getAge();
                            profile_info[1] = client.getMajor();
                            profile_info[2] = client.getPlace();
                            profile_info[3] = client.getFb1();
                            profile_info[4] = client.getFb2();
                            profile_info[5] = client.getFood();
                            profile_info[6] = client.getLang();
                            profile_info[7] = client.getHobby();

                            Student.getInstance().setProfile(profile_info);
                            Student.getInstance().setIntro(client.getIntro());
                            Student.getInstance().setContact(client.getContact());
                            startActivity(intent);
                        }else if(response.code() == 404){
                            Toast.makeText(LoginActivity.this, "Wrong Credentials CODE # 2",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResult> call, @NonNull Throwable t) {
                        //실패시 알림
                        Toast.makeText(LoginActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}