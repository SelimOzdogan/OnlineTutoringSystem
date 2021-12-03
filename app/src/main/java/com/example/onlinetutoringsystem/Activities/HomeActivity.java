package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.onlinetutoringsystem.Data.TransactionDao;
import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.Transaction;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;
import com.example.onlinetutoringsystem.RecyclerAdapter;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    List<Instructor> instructorList;
    private RecyclerView instructors;
    private RecyclerView.Adapter adapter;
    private RecyclerAdapter.RecyclerViewClickListener listener;
    SearchView searchView;
    User user;
    UserDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_view);
        setOnClickListener();

        user = (User) getIntent().getSerializableExtra("User");
        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        AddData();
        instructorList = dataBase.getIntructorDao().getInstructorList();

        searchView = findViewById(R.id.searchView);
        CharSequence query = searchView.getQuery();

        // perform set on query text listener event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                instructorList = dataBase.getIntructorDao().searchInstructor("%"+newText+"%");
                adapter = new RecyclerAdapter(instructorList, listener);
                instructors.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

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

    private void AddData() {
        TransactionDao transactionDao = dataBase.getTransactionDao();
        if (!(transactionDao.getTransactions(String.valueOf(user.getId())).size() > 0)) {
            Calendar calc = new GregorianCalendar(2021, 9, 5, 8, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 1, 15.0, calc.getTime()));
            calc = new GregorianCalendar(2021, 10, 15, 10, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 4, 25.0, calc.getTime()));
            calc = new GregorianCalendar(2021, 8, 25, 11, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 5, 20.0, calc.getTime()));
            calc = new GregorianCalendar(2021, 7, 5, 11, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 2, 17.0, calc.getTime()));
            calc = new GregorianCalendar(2021, 12, 7, 9, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 1, 22.0, calc.getTime()));
            calc = new GregorianCalendar(2021, 12, 6, 10, 00);
            transactionDao.insert(new Transaction(String.valueOf(user.getId()), 6, 20.0, calc.getTime()));
        }
    }
}