package com.talk2sign.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_view);

        LinearLayout registerButton = (LinearLayout) findViewById(R.id.linear_layout_register);

        registerButton.setOnClickListener(v -> {
            confirmRegister("Ondo erregistratuta!", "Erregistratuta izan zara, orain saioa hasi dezakezu.");
        });

    }
    public void confirmRegister(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .show();
    }
}