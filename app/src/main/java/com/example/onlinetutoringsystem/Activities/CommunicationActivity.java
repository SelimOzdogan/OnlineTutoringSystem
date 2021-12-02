package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;

public class CommunicationActivity extends AppCompatActivity {
    Button btnWhatsapp, btnViber, btnZoom, buttonCommunicationSchedule;
    TextView textViewSelectedApp;
    User user;
    Instructor instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication_layout);

        user = (User) getIntent().getSerializableExtra("User");
        instructor = (Instructor) getIntent().getSerializableExtra("Instructor");

        btnWhatsapp = findViewById(R.id.buttonWhatsapp);
        btnViber = findViewById(R.id.buttonViber);
        btnZoom = findViewById(R.id.buttonZoom);
        textViewSelectedApp = findViewById(R.id.textViewAppSelected);
        buttonCommunicationSchedule = findViewById(R.id.buttonCommunicationSchedule);

        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSelectedApp.setText("You selected Whatapps for the session.");
            }
        });

        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSelectedApp.setText("You selected Zoom for the session.");
            }
        });

        btnViber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewSelectedApp.setText("You selected Viber for the session.");
            }
        });

        buttonCommunicationSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CommunicationActivity.this, ScheduleActivity.class);
                i.putExtra("User", user);
                i.putExtra("Instructor", instructor);
                startActivity(i);
            }
        });

    }
}