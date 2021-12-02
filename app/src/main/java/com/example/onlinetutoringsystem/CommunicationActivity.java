package com.example.onlinetutoringsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CommunicationActivity extends AppCompatActivity {
    Button btnWhatsapp, btnViber, btnZoom;
    TextView textViewSelectedApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication_layout);

        btnWhatsapp = findViewById(R.id.buttonWhatsapp);
        btnViber = findViewById(R.id.buttonViber);
        btnZoom = findViewById(R.id.buttonZoom);
        textViewSelectedApp = findViewById(R.id.textViewAppSelected);

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

    }
}