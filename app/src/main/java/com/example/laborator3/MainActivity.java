package com.example.laborator3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etLastName, etDob;
    private Button btnOk, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.pale_red));

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etLastName);
        etDob = findViewById(R.id.etDob);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setBackgroundColor(getResources().getColor(R.color.dark_red));
        btnCancel.setBackgroundColor(getResources().getColor(R.color.dark_red));

        btnOk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("lastName", etLastName.getText().toString());
            intent.putExtra("dob", etDob.getText().toString());
            startActivity(intent);
        });

        btnCancel.setOnClickListener(v -> {
            etName.setText("");
            etLastName.setText("");
            etDob.setText("");
        });
    }
}