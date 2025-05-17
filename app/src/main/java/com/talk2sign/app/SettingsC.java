package com.talk2sign.app;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsC extends AppCompatActivity {

    private Spinner spinnerAppLanguage;
    private Spinner spinnerTranslatorLanguage;
    private Spinner spinnerAppTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_view);

        spinnerAppLanguage = findViewById(R.id.spinnerAppLanguage);
        spinnerTranslatorLanguage = findViewById(R.id.spinnerTranslatorLanguage);
        spinnerAppTheme = findViewById(R.id.spinnerAppTheme);


        // Data for the spinners
        String[] languages = {"Euskera", "Español", "English"};
        String[] themes = {"Iluna", "Argia"};

        // Set adapters
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                languages
        );

        ArrayAdapter<String> themeAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                themes
        );

        spinnerAppLanguage.setAdapter(languageAdapter);
        spinnerTranslatorLanguage.setAdapter(languageAdapter);
        spinnerAppTheme.setAdapter(themeAdapter);

        ImageView backBtn  = (ImageView) findViewById(R.id.backButton);
        Button saveBtn = (Button) findViewById(R.id.saveButton);

        backBtn.setOnClickListener(v -> {
            // Navigate back to MainC
            finish();
        });

        saveBtn.setOnClickListener(v -> {
            // Save settings and show confirmation
            confirmChanges("Aldaketak gorde dira!", "Aldaketak ondo gorde dira.");
        });
    }

    public void confirmChanges(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .show();
    }
}