package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;
import com.example.onlinetutoringsystem.RecyclerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Instructor> instructorList;
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
        UserDatabase dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        instructorList = dataBase.getIntructorDao().getInstructorList();

        this.instructors = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        this.instructors.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(instructorList, listener);
        this.instructors.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onclick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("Instructor", instructorList.get(position));
                intent.putExtra("User", user);
                startActivity(intent);
            }
        };
    }
}