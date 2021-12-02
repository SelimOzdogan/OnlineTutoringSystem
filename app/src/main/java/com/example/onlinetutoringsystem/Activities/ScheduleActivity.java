package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleActivity extends AppCompatActivity {
    Button button10, button11, button12, button14, button16, button19;
    CalendarView calendarView2;
    User user;
    Instructor instructor;
    Date selectedDate;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);

        user = (User) getIntent().getSerializableExtra("User");
        instructor = (Instructor) getIntent().getSerializableExtra("Instructor");

        button10 = findViewById(R.id.buttonTime1);
        button11 = findViewById(R.id.buttonTime2);
        button12 = findViewById(R.id.buttonTime3);
        button14 = findViewById(R.id.buttonTime4);
        button16 = findViewById(R.id.buttonTime5);
        button19 = findViewById(R.id.buttonTime6);

        calendarView2 = findViewById(R.id.calendarView2);
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendarView2.getDate());
        selectedDate = calendar.getTime();
        calendarView2.setOnDateChangeListener((@NonNull CalendarView calendarView, int i, int i1, int i2) -> {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            selectedDate = calendar.getTime();
        });

        button10.setOnClickListener((View view) -> {
            try {
                openPayment("10:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        button11.setOnClickListener((View view) -> {
            try {
                openPayment("11:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        button12.setOnClickListener((View view) -> {
            try {
                openPayment("12:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        button14.setOnClickListener((View view) -> {
            try {
                openPayment("14:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        button16.setOnClickListener((View view) -> {
            try {
                openPayment("16:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        button19.setOnClickListener((View view) -> {
            try {
                openPayment("19:00");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    private void openPayment(String time) throws ParseException {
        Intent i = new Intent(ScheduleActivity.this, PaymentActivity.class);
        i.putExtra("User", user);
        i.putExtra("Instructor", instructor);
        i.putExtra("COURSEDATETIME", getFormattedDateTime(time));
        startActivity(i);
    }

    private String getFormattedDateTime(String time) throws ParseException {
        String[] timeInArray = time.split(":");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(selectedDate.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeInArray[0]));
        calendar.set(Calendar.MINUTE, Integer.parseInt(timeInArray[1]));

        selectedDate = calendar.getTime();

        return new SimpleDateFormat("yyyy/MM/dd hh:mm").format(selectedDate.getTime());
    }
}