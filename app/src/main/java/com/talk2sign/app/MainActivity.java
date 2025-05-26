package com.talk2sign.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.LocaleList;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public static User testUser = new User("Test User", "TEST", "test@test.eus", "1234", "2003-01-01");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_view);

        LinearLayout loginButton = (LinearLayout) findViewById(R.id.login_button);
        LinearLayout registerButton = (LinearLayout) findViewById(R.id.register_button);
        TextView forgotPassword = (TextView) findViewById(R.id.forgot_password_link);
        LinearLayout jarraituErregGabe = (LinearLayout) findViewById(R.id.continue_without_registering_section);
        EditText emailInput = (EditText) findViewById(R.id.email_edit_text);
        EditText passwordInput = (EditText) findViewById(R.id.password_label);

        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Errorea")
                        .setMessage("Email-a eta pasahitza bete behar dira.")
                        .setPositiveButton("Ados", null)
                        .show();
                return;
            }

            if (!email.equals(testUser.getEmail()) || !password.equals(testUser.getPassword())) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Errorea")
                        .setMessage("Email-a edo pasahitza okerra da.")
                        .setPositiveButton("Ados", null)
                        .show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, MainC.class);
            startActivity(intent);
        });

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterC.class);
            startActivity(intent);
        });

        forgotPassword.setOnClickListener(v -> {
            forgotPasswd("Sartu zure email-a", new DialogInterface.OnClickListener() {
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

        jarraituErregGabe.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainC.class);
            startActivity(intent);
        });

    }

    public void forgotPasswd(String title, DialogInterface.OnClickListener okListener) {
        final EditText input = new EditText(this);

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setView(input)
                .setPositiveButton("Bidali", new DialogInterface.OnClickListener() {
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