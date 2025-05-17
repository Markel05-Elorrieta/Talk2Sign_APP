package com.talk2sign.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_view);

        Button passwdChangeButton = findViewById(R.id.changePasswordButton);
        passwdChangeButton.setOnClickListener(v -> {
            changePasswd("Sartu pasahitz berria", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    EditText input = alertDialog.findViewById(android.R.id.edit);
                    if (input == null) {
                        input = (EditText) alertDialog.findViewById(android.R.id.content);
                    }
                }
            });
        });

        Button saveChangesButton = findViewById(R.id.saveChangesButton);
        saveChangesButton.setOnClickListener(v -> {
            finish();
        });
    }

    public void changePasswd(String title, DialogInterface.OnClickListener okListener) {
        final EditText input = new EditText(this);

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setView(input)
                .setPositiveButton("Aldatu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Pass the input text by calling the provided listener
                        okListener.onClick(dialog, which);
                    }
                })
                .setNegativeButton("Atzera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}