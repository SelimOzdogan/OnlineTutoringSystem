package com.example.onlinetutoringsystem.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.onlinetutoringsystem.Data.UserDatabase;
import com.example.onlinetutoringsystem.Model.Transaction;
import com.example.onlinetutoringsystem.Model.User;
import com.example.onlinetutoringsystem.R;

public class PaymentActivity extends AppCompatActivity {
    private static final Double COMMISSIONRATE = 0.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        UserDatabase db = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        User user = (User)getIntent().getSerializableExtra("User");
        String courseID = getIntent().getExtras().getString("COURSEID");

        Date coursedatetime = null;
        try {
            coursedatetime = new SimpleDateFormat("MM/dd/yyyy hh:hh").parse(getIntent().getExtras().getString("COURSEDATETIME"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Double price, commission = 0.0;
        price = Double.parseDouble(getIntent().getExtras().getString("PRICE"));
        commission = price * COMMISSIONRATE;
        final Double total = price + commission;

        TextView textViewPaymentUserInfo = findViewById(R.id.textViewPaymentUserInfo);
        TextView textViewPaymentDateTime = findViewById(R.id.textViewPaymentDateTime);
        TextView textViewPaymentDetails = findViewById(R.id.textViewPaymentDetails);
        CheckBox checkBoxPaymentAgree = findViewById(R.id.checkBoxPaymentAgree);
        Button btnPaymentPay = findViewById(R.id.btnPaymentPay);

        textViewPaymentUserInfo.setText(user.getUserName());
        textViewPaymentDateTime.setText(getDateInfo(coursedatetime));
        textViewPaymentDetails.setText(getPaymentDetail(price, commission));

        btnPaymentPay.setOnClickListener((View view) -> {
            Transaction transaction = new Transaction(String.valueOf(user.getId()), courseID, total);
            db.gettransactionDao().insert(transaction);
        });
    }

    DecimalFormat decimalFormat = new DecimalFormat("\u00A4#.##");

    private String getPaymentDetail(Double price, Double commission) {
        StringBuilder outputText = new StringBuilder();
        outputText.append(String.format("%-30s%-20s\n", "Service details", "Price per hour"));
        outputText.append(String.format("%-30s%15s\n", "1 hour lesson", decimalFormat.format(price)));
        outputText.append(String.format("%-30s%15s\n", "Transaction fee", decimalFormat.format(commission)));
        outputText.append("\n");
        outputText.append(String.format("%-30s%15s\n", "Total", decimalFormat.format(price + commission)));
        return outputText.toString();
    }

    SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("E, MMM dd, yyyy hh:mma z");// 'GST' Z

    private String getDateInfo(Date coursedatetime) {
        StringBuilder outputText = new StringBuilder();
        outputText.append(String.format("%-40s\n", "Date and Time"));
        outputText.append(dateTimeFormatter.format(coursedatetime));
//        outputText.append(String.format("%-30s%15s\n", "Transaction fee", df.format((double) price * 0.02)));
        return outputText.toString();
    }
}