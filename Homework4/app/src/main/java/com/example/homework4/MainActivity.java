package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getDetail = findViewById(R.id.getDetail);
        TextView info = findViewById(R.id.info);
        String username = getIntent().getStringExtra("keyname");
        String userSurname = getIntent().getStringExtra("keysurname");
        String state = getIntent().getStringExtra("keystate");
        String suburb = getIntent().getStringExtra("keysuburb");
        String major = getIntent().getStringExtra("keymajor");
        String phonenumber = getIntent().getStringExtra("keyphone");

        info.setText("Name   :  " + username + " " + userSurname +"\nID          :  " +  state + "\nMajor   :  " + major + "\nPhone  :  " + phonenumber);

        getDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GetDetailActivity.class);
                startActivity(intent);

            }
        });
    }
}