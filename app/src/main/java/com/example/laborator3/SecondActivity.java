package com.example.laborator3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Spinner spinnerSpecialty;
    private RadioGroup radioGroup;
    private ListView listViewPrograms, listViewLanguages;
    private Button btnOk, btnCancel;
    private ImageView imageView;
    private String selectedProgram, selectedForm, selectedSpecialty;
    private StringBuilder selectedLanguages = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.pale_red));

        listViewPrograms = findViewById(R.id.listViewPrograms);
        radioGroup = findViewById(R.id.radioGroup);
        spinnerSpecialty = findViewById(R.id.spinnerSpecialty);
        listViewLanguages = findViewById(R.id.listViewLanguages);
        imageView = findViewById(R.id.imageView);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setBackgroundColor(getResources().getColor(R.color.dark_red));
        btnCancel.setBackgroundColor(getResources().getColor(R.color.dark_red));
        imageView.setImageResource(R.drawable.ulim);

        listViewPrograms.setOnItemClickListener((parent, view, position, id) ->
                selectedProgram = (String) parent.getItemAtPosition(position));

        radioGroup.setOnCheckedChangeListener((group, checkedId) ->
                selectedForm = ((RadioButton) findViewById(checkedId)).getText().toString());

        btnOk.setOnClickListener(v -> {
            selectedLanguages.setLength(0);
            for (int i = 0; i < listViewLanguages.getCount(); i++) {
                if (listViewLanguages.isItemChecked(i)) {
                    selectedLanguages.append(listViewLanguages.getItemAtPosition(i)).append(", ");
                }
            }
            if (selectedLanguages.length() > 2) {
                selectedLanguages.setLength(selectedLanguages.length() - 2);
            }
            selectedSpecialty = spinnerSpecialty.getSelectedItem().toString();

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtras(getIntent());
            intent.putExtra("program", selectedProgram);
            intent.putExtra("form", selectedForm);
            intent.putExtra("specialty", selectedSpecialty);
            intent.putExtra("languages", selectedLanguages.toString());
            startActivity(intent);
        });

        btnCancel.setOnClickListener(v -> {
            listViewPrograms.clearChoices();
            listViewLanguages.clearChoices();
            radioGroup.clearCheck();
            spinnerSpecialty.setSelection(0);
        });
    }
}
