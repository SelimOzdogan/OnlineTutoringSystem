package com.example.onlinetutoringsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.onlinetutoringsystem.Data.TransactionDao;
import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.Transaction;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;
import com.example.onlinetutoringsystem.TransactionAdapter;

import java.util.ArrayList;
import java.util.List;

public class TransactionActivity extends AppCompatActivity {

    UserDatabase db;
    List<Transaction> TransactionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        db = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        TransactionDao transactionDao = db.getTransactionDao();

        User user = (User) getIntent().getSerializableExtra("User");
        Instructor instructor = (Instructor) getIntent().getSerializableExtra("Instructor");

        TransactionList = transactionDao.getTransactions(String.valueOf(user.getId()));
        Button btnHome = findViewById(R.id.btnAddCourse);

        ListView listViewCourses = findViewById(R.id.listTransactionHeader);
        View header = getLayoutInflater().inflate(R.layout.layout_transaction_headers, null);
        listViewCourses.addHeaderView(header);
        listViewCourses.setAdapter(null);

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView recycleViewComponents = findViewById(R.id.recycleViewTranasction);
        TransactionAdapter courseListAdapter = new TransactionAdapter(TransactionList, db);
        recycleViewComponents.setLayoutManager(lm);
        recycleViewComponents.setAdapter(courseListAdapter);

        btnHome.setOnClickListener((View view) -> {
            Intent i = new Intent(TransactionActivity.this, HomeActivity.class);
            i.putExtra("User", user);
            startActivity(i);
            finish();
        });
    }
}