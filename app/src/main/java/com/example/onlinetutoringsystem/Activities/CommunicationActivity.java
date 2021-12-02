package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinetutoringsystem.R;

public class CommunicationActivity extends AppCompatActivity {
    Button btnWhatsapp, btnViber, btnZoom, button4;
    TextView textViewSelectedApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication_layout);

        btnWhatsapp = findViewById(R.id.buttonWhatsapp);
        btnViber = findViewById(R.id.buttonViber);
        btnZoom = findViewById(R.id.buttonZoom);
        textViewSelectedApp = findViewById(R.id.textViewAppSelected);
        button4 = findViewById(R.id.button4);

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

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CommunicationActivity.this, PaymentActivity.class);
//                i.putExtra("User", user);
                startActivity(i);
            }
        });

    }
}