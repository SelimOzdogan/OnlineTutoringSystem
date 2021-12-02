package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;
import com.example.onlinetutoringsystem.RecyclerAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Instructor> instructor = instructors();
    private RecyclerView instructors;
    private RecyclerView.Adapter adapter;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view);
        setOnClickListener();

        user = (User) getIntent().getSerializableExtra("User");

        this.instructors = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.instructors.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(instructor, listener);
        this.instructors.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onclick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("Instructor", instructor.get(position));
                intent.putExtra("User", user);
                startActivity(intent);
            }
        };
    }

    private ArrayList<Instructor> instructors() {
        ArrayList<Instructor> instructor = new ArrayList<>();

        instructor.add(new Instructor("1","Alan Taylor", "Film Scoring",20.0));
        instructor.add(new Instructor("2","Michael Gregg", "Music Theory",25.0));
        instructor.add(new Instructor("3","Tass Pete", "Songwriting",30.0));
        instructor.add(new Instructor("4","David Mai", "Music Composition",20.0));
        instructor.add(new Instructor("5","Berkley Hill", "Music Production",15.0));
        instructor.add(new Instructor("6","Alex Oscar", "Sound Engineering",18.0));
        instructor.add(new Instructor("7","Tommy Nguyen", "Jazz Composition",22.0));
        instructor.add(new Instructor("8","Joe Pass", "String Instrument",20.0));

        return instructor;
    }
}