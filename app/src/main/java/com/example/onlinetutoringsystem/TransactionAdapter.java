package com.example.onlinetutoringsystem;

import android.app.DatePickerDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.onlinetutoringsystem.Data.InstructorDao;
import com.example.onlinetutoringsystem.Data.TransactionDao;
import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Instructor;
import com.example.onlinetutoringsystem.Model.Transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ComponentHolder> {

    public List<Transaction> getComponentList() {
        return TransactionList;
    }


    public void setComponentList(List<Transaction> transactionsList) {
        TransactionList = transactionsList;
    }

    List<Transaction> TransactionList;
    UserDatabase db;
    InstructorDao instructorDao;
    ComponentHolder courseHolder;

    public TransactionAdapter(List<Transaction> transactionsList, UserDatabase database) {
        TransactionList = transactionsList;
        db = database;
        instructorDao = db.getIntructorDao();
    }

    @NonNull
    @Override
    public ComponentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_transaction, parent, false);

        courseHolder = new ComponentHolder(courseItemView);
        return courseHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentHolder holder, int position) {
        Transaction transaction = TransactionList.get(position);
        Instructor instructor = db.getIntructorDao().getInstructor(transaction.getInstructorId());

        TextView TextTrans1 = holder.componentItem.findViewById(R.id.TextTrans1);
        TextTrans1.setText(String.valueOf(instructor.getInstructorName()));
        TextTrans1.setGravity(Gravity.CENTER_VERTICAL);

        TextView TextTrans2 = holder.componentItem.findViewById(R.id.TextTrans2);
        TextTrans2.setText(String.valueOf(transaction.getAmount()));
        TextTrans2.setGravity(Gravity.CENTER_VERTICAL);

        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("MM/dd/yyyy hh:mma");

        TextView TextTrans3 = holder.componentItem.findViewById(R.id.TextTrans3);
        TextTrans3.setText(dateTimeFormatter.format(transaction.getDate()));

        TextTrans3.setGravity(Gravity.CENTER_VERTICAL);
    }

    @Override
    public int getItemCount() {
        return TransactionList.size();
    }

    public class ComponentHolder extends RecyclerView.ViewHolder {

        View componentItem;

        public ComponentHolder(@NonNull View itemView) {
            super(itemView);
            componentItem = itemView;

        }
    }
}
