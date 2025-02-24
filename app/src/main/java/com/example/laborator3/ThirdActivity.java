package com.example.laborator3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private TextView textViewPersonalInfo, textViewProgramInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.white));

        textViewPersonalInfo = findViewById(R.id.textViewPersonalInfo);
        textViewProgramInfo = findViewById(R.id.textViewProgramInfo);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String lastName = intent.getStringExtra("lastName");
        String dob = intent.getStringExtra("dob");

        String program = intent.getStringExtra("program");
        String form = intent.getStringExtra("form");
        String specialty = intent.getStringExtra("specialty");
        String languages = intent.getStringExtra("languages");

        textViewPersonalInfo.setText("Nume: " + name + "; Prenume: " + lastName + "; Data nasterii: " + dob);
        textViewProgramInfo.setText("Studii: " + program + "; Forma de studii: " + form + "; Specialitatea: " + specialty + "; Limbi straine: " + languages);
    }
}