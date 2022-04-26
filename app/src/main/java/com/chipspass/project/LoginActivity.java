package com.chipspass.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText edUserName;
    private TextInputEditText edPassword;
    private Button btnLogin;
    private Button btnSignup;

    private final String CREDINTIAL_SHARED_PREF = "our_shared_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUserName = findViewById(R.id.etUserName);
        edPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences credintials = getSharedPreferences(CREDINTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                String strUsername = credintials.getString("Username", null);
                String strPassword = credintials.getString("Password", null);

                String username_from_ed = edUserName.getText().toString();
                String password_from_ed = edPassword.getText().toString();

                if (strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed))
                {
                    if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(intent);
                    } else{
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}