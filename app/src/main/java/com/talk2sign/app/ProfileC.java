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
    public static User testUser = new User("Test User", "TEST", "test@test.eus", "1234", "2003-01-01");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_view);

        EditText nameInput = findViewById(R.id.Name_ET);
        EditText surnameInput = findViewById(R.id.Surname_ET);
        EditText birthdateInput = findViewById(R.id.DateBirth_ET);
        EditText emailInput = findViewById(R.id.Email_ET);

        nameInput.setText(testUser.getName());
        surnameInput.setText(testUser.getSurname());
        birthdateInput.setText(testUser.getBirthDate());
        emailInput.setText(testUser.getEmail());

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
            String name = nameInput.getText().toString();
            String surname = surnameInput.getText().toString();
            String birthdate = birthdateInput.getText().toString();
            String email = emailInput.getText().toString();
            if (name.isEmpty() || surname.isEmpty() || birthdate.isEmpty() || email.isEmpty()) {
                new AlertDialog.Builder(ProfileC.this)
                        .setTitle("Errorea")
                        .setMessage("Datu guztiak bete behar dira.")
                        .setPositiveButton("Ados", null)
                        .show();
                return;
            }

            // Update the test user with the new data
            testUser.setName(name);
            testUser.setSurname(surname);
            testUser.setBirthDate(birthdate);
            testUser.setEmail(email);

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