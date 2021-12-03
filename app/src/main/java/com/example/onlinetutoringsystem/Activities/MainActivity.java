package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlinetutoringsystem.Data.InstructorDao;
import com.example.onlinetutoringsystem.Data.UserDao;
import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextEmail, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
        Addinstructors();
        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                User user = db.getUser(email, password);
                if (user != null) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Addinstructors() {
        InstructorDao instructorDao = dataBase.getIntructorDao();
        if (!(instructorDao.getInstructorList().size() > 0)) {
            instructorDao.insertInstructor(new Instructor("Alan Taylor", "Film Scoring", 20.0));
            instructorDao.insertInstructor(new Instructor("Michael Gregg", "Music Theory", 25.0));
            instructorDao.insertInstructor(new Instructor("Tass Pete", "Songwriting", 30.0));
            instructorDao.insertInstructor(new Instructor("David Mai", "Music Composition", 20.0));
            instructorDao.insertInstructor(new Instructor("Berkley Hill", "Music Production", 15.0));
            instructorDao.insertInstructor(new Instructor("Alex Oscar", "Sound Engineering", 18.0));
            instructorDao.insertInstructor(new Instructor("Tommy Nguyen", "Jazz Composition", 22.0));
            instructorDao.insertInstructor(new Instructor("Joe Pass", "String Instrument", 20.0));
        }
    }
}
