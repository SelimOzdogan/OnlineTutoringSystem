package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinetutoringsystem.R;

public class ScheduleActivity extends AppCompatActivity {
    Button button10,button11,button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);

        button10 = findViewById(R.id.buttonTime1);
        button11 = findViewById(R.id.buttonTime2);
        button12 = findViewById(R.id.buttonTime3);



        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScheduleActivity.this, PaymentActivity.class);
//                i.putExtra("User", user);
                startActivity(i);
            }
        });
    }
}