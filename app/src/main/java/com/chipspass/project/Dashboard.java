package com.chipspass.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity
{

    private Button btnNewForm;
    private Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnNewForm = findViewById(R.id.btnNewForm);
        btnList = findViewById(R.id.btnPreviousList);

        btnNewForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, RegistrationFormActivity.class);
                startActivity(intent);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intentlist = new Intent(Dashboard.this, PreviousListActivity.class);
               // startActivity(intentlist);
            }
        });
    }
}