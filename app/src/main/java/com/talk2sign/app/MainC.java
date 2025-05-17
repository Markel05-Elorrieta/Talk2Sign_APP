package com.talk2sign.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_view);

        ImageView settingsButton = (ImageView) findViewById(R.id.settingsButton);
        ImageView profileButton = (ImageView) findViewById(R.id.profileButton);

        settingsButton.setOnClickListener(v -> {
            // Navigate to SettingsC
            startActivity(new Intent(MainC.this, SettingsC.class));
        });

        profileButton.setOnClickListener(v -> {
            // Navigate to ProfileC
            startActivity(new Intent(MainC.this, ProfileC.class));
        });

    }
}