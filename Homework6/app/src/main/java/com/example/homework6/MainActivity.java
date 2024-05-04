package com.example.homework6;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView dateTimeDisplay;
    private Button dateButton;
    private Button timeButton;
    private Button exitButton;

    private Calendar dateTime = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTimeDisplay = findViewById(R.id.date_time_display);
        dateButton = findViewById(R.id.date_button);
        timeButton = findViewById(R.id.time_button);
        exitButton = findViewById(R.id.exit_button);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showExitConfirmationDialog();
            }
        });
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateTime.set(Calendar.YEAR, year);
                        dateTime.set(Calendar.MONTH, monthOfYear);
                        dateTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        calLiveDay(dateTime);
                    }
                },
                dateTime.get(Calendar.YEAR),
                dateTime.get(Calendar.MONTH),
                dateTime.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        dateTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        dateTime.set(Calendar.MINUTE, minute);
                        calLiveDay(dateTime);
                    }
                },
                dateTime.get(Calendar.HOUR_OF_DAY),
                dateTime.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }

    private void calLiveDay (Calendar birthTime) {
        int yearToDay;
        int monthToDay;
        int dayToDay;
        int liveDay;

        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        int curMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int curDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        int year = birthTime.get(Calendar.YEAR);
        int month = birthTime.get(Calendar.MONTH) + 1;
        int day = birthTime.get(Calendar.DAY_OF_MONTH);

        yearToDay = (curYear - year) * 365;
        if (curMonth >= month) {
            monthToDay = (curMonth - month) * 30;
        } else {
            monthToDay = ((curMonth - month) + 12) * 30 - 365;
        }
        dayToDay = curDay - day;
        liveDay = yearToDay + monthToDay + dayToDay;

        dateTimeDisplay.setText("Up time: " + liveDay + " days");
    }
}