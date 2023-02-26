package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class LoginActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "";

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
                //Call<Student> call = executeLogin(map);
                map.put("student_id", UserID.getInstance().getUserId());//wisconsin ID with signal > output : student object

                Call<Student> call = retrofitInterface.executeLogin(map);

                call.enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {
                        //성공시 알림
                        if(response.code() == 200){
                            startActivity(intent);
                        }else if(response.code() == 404){
                            Toast.makeText(LoginActivity.this, "Wrong Credentials",
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {
                        //실패시 알림
                        Toast.makeText(LoginActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }

    Call<Student> executeLogin(@Body HashMap<String, String> map){
        //id를 가지고 어떻게 student를 가져오조?
        //Student student =
        return null; //need-to-be-changed
    }
}