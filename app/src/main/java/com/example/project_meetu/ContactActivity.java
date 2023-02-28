package com.example.project_meetu;

import android.content.Intent;
import android.os.Bundle;
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

public class ContactActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:3000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        Button BtnContactActivity = findViewById(R.id.btn_contact_activity);
        final EditText introEdit = findViewById(R.id.intro);
        final EditText contactEdit = findViewById(R.id.contact);

        BtnContactActivity.setOnClickListener(view -> {
            Intent intent = new Intent(ContactActivity.this,MainActivity.class);

            HashMap<String, String> map = new HashMap<>();

            map.put("name",Student.getInstance().getName());
            map.put("student_id", Student.getInstance().getId());
            map.put("age",Student.getInstance().getProfile()[0]);
            map.put("major",Student.getInstance().getProfile()[1]);
            map.put("place",Student.getInstance().getProfile()[2]);
            map.put("fb1",Student.getInstance().getProfile()[3]);
            map.put("fb2",Student.getInstance().getProfile()[4]);
            map.put("food",Student.getInstance().getProfile()[5]);
            map.put("lang",Student.getInstance().getProfile()[6]);
            map.put("hobby",Student.getInstance().getProfile()[7]);
            map.put("intro",introEdit.getText().toString());
            map.put("contact",contactEdit.getText().toString());

            Call<Void> call = retrofitInterface.executeSignup(map);

            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                    //성공시
                    if(response.code() == 200){
                        Toast.makeText(ContactActivity.this, "Signup Successul",
                                Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }else if(response.code() == 400){
                        Toast.makeText(ContactActivity.this, "Wrong Credentials CODE # 1",
                                Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(ContactActivity.this, "Wrong access" + response.code(),
                                Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                    //실패시 알림
                    Toast.makeText(ContactActivity.this, t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        });

    }

}