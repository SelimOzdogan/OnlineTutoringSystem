package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;

import java.util.Timer;
import java.util.TimerTask;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        User user = (User) getIntent().getSerializableExtra("User");

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Intent i = new Intent(FinishActivity.this, HomeActivity.class);
                i.putExtra("User", user);
                startActivity(i);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,3000); //delay in milliseconds
    }
}