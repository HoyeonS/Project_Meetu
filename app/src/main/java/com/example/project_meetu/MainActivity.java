package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        Button SetupBtn = findViewById(R.id.SetupBtn);


        SetupBtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                signIn();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                GoogleSignInAccount acct = task.getResult(ApiException.class);

                if (acct != null) {
                    Student.getInstance().setName(acct.getDisplayName());
                    String user_id = acct.getEmail().substring(0, acct.getEmail().indexOf('@'));
                    Student.getInstance().setId(user_id);
                    Student.getInstance().setName(acct.getDisplayName());
                    Student.getInstance().setPhoto(acct.getPhotoUrl());

                    HashMap<String, String> map = new HashMap<>();

                    map.put("student_id", user_id);

                    Call<LoginResult> call = retrofitInterface.executeLogin(map);

                    call.enqueue(new Callback<LoginResult>() {
                        @Override
                        public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            if(response.code() == 200){ //Find
                                Toast.makeText(MainActivity.this, "Login Successful",
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
                                Intent intent = new Intent(MainActivity.this,StatusActivity.class);
                                startActivity(intent);
                            }else if(response.code() == 404){ //Not find
                                Student.getInstance().setId(user_id);
                                Student.getInstance().setName(acct.getDisplayName());
                                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Wrong access" + response.code(),
                                        Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResult> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });


                }
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Wrong Credential", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void signIn() {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);
    }

}