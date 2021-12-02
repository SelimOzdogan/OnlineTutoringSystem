package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.R;
import com.example.onlinetutoringsystem.RecyclerAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Instructor> instructor = instructors();
    private RecyclerView instructors;
    private RecyclerView.Adapter adapter;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view);
        setOnClickListener();
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
                intent.putExtra("profile_name", instructor.get(position).getInstructorName());
                intent.putExtra("profile_major", instructor.get(position).getInstructorMajor());
                startActivity(intent);
            }
        };
    }
    private ArrayList<Instructor> instructors() {
        ArrayList<Instructor> instructor = new ArrayList<>();

        instructor.add(new Instructor("Alan Taylor", "Film Scoring"));
        instructor.add(new Instructor("Michael Gregg", "Music Theory"));
        instructor.add(new Instructor("Tass Pete", "Songwriting"));
        instructor.add(new Instructor("David Mai", "Music Composition"));
        instructor.add(new Instructor("Berkley Hill", "Music Production"));
        instructor.add(new Instructor("Alex Oscar", "Sound Engineering"));
        instructor.add(new Instructor("Tommy Nguyen", "Jazz Composition"));
        instructor.add(new Instructor("Joe Pass", "String Instrument"));

        return instructor;
    }
}