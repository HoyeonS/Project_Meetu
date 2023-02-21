package com.example.project_meetu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Spinner ageSpinner = (Spinner) findViewById(R.id.AgeSpinner);
        ArrayAdapter<CharSequence> adapterAge = ArrayAdapter.createFromResource(this, R.array.age_selections, android.R.layout.simple_spinner_item);
        ageSpinner.setAdapter(adapterAge);

        Spinner majorSpinner = (Spinner) findViewById(R.id.MajorSpinner);
        ArrayAdapter<CharSequence> adapterMajor = ArrayAdapter.createFromResource(this, R.array.major_selections, android.R.layout.simple_spinner_item);
        majorSpinner.setAdapter(adapterMajor);

        Spinner placeSpinner = (Spinner) findViewById(R.id.PlaceSpinner);
        ArrayAdapter<CharSequence> adapterPlace = ArrayAdapter.createFromResource(this, R.array.place_selections, android.R.layout.simple_spinner_item);
        placeSpinner.setAdapter(adapterPlace);

        Spinner fBSpinner = (Spinner) findViewById(R.id.FBSpinner);
        ArrayAdapter<CharSequence> adapterFB = ArrayAdapter.createFromResource(this, R.array.FB_selections, android.R.layout.simple_spinner_item);
        fBSpinner.setAdapter(adapterFB);

        Spinner fB2Spinner = (Spinner) findViewById(R.id.FB2Spinner);
        ArrayAdapter<CharSequence> adapterFB2 = ArrayAdapter.createFromResource(this, R.array.FB2_selections, android.R.layout.simple_spinner_item);
        fB2Spinner.setAdapter(adapterFB2);

        Spinner foodSpinner = (Spinner) findViewById(R.id.FoodSpinner);
        ArrayAdapter<CharSequence> adapterFood = ArrayAdapter.createFromResource(this, R.array.food_selections, android.R.layout.simple_spinner_item);
        foodSpinner.setAdapter(adapterFood);

        Spinner langSpinner = (Spinner) findViewById(R.id.LangSpinner);
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.lang_selections, android.R.layout.simple_spinner_item);
        langSpinner.setAdapter(adapterLang);

        Spinner hobbySpinner = (Spinner) findViewById(R.id.HobbySpinner);
        ArrayAdapter<CharSequence> adapterHobby = ArrayAdapter.createFromResource(this, R.array.hobby_selections, android.R.layout.simple_spinner_item);
        hobbySpinner.setAdapter(adapterHobby);

        Button StartRegBtn = findViewById(R.id.buttonFinalStep);

        StartRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String age = ageSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[0] = age;

                String major = majorSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[1] = major;

                String place = placeSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[2] = place;

                String fb = fBSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[3] = fb;

                String fb2 = fB2Spinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[4] = fb2;

                String food = foodSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[5] = food;

                String lang = langSpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[6] = lang;

                String hobby = hobbySpinner.getSelectedItem().toString();
                Student.getInstance().getProfile()[7] = hobby;

                Intent intent = new Intent(ProfileActivity.this,ContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
