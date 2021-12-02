package com.example.onlinetutoringsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ProfileActivity extends AppCompatActivity {
    TextView textProfileName, textProfileMajor;
    ImageView imageProfileAva;
    Button buttonProfileRepertoire, buttonProfileSchedule, buttonMeet;
    String profileName = "";
    String profileMajor = "";
    int profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        textProfileName = findViewById(R.id.textViewProfileName);
        textProfileMajor = findViewById(R.id.textViewProfileMajor);
        imageProfileAva = findViewById(R.id.imageProfileAva);
        buttonProfileRepertoire = findViewById(R.id.buttonProfileRepertoire);
        buttonProfileSchedule = findViewById(R.id.buttonProfileSchedule);
        buttonMeet = findViewById(R.id.buttonMeetNow);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            profileName = extras.getString("profile_name");
            profileMajor = extras.getString("profile_major");
        }

        textProfileName.setText(profileName);
        textProfileMajor.setText(profileMajor);

        buttonProfileRepertoire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, RepertoireActivity.class);
                startActivity(i);
            }
        });

        buttonProfileSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, ScheduleActivity.class);
                startActivity(i);
            }
        });

        buttonMeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, CommunicationActivity.class);
                startActivity(i);
            }
        });

    }

}