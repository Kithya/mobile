package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetDetailActivity extends AppCompatActivity {

    private EditText firstname,surname,major;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_detail);

        Button confirm = findViewById(R.id.comfirm);
        EditText firstName = findViewById(R.id.firstName);
        EditText surName = findViewById(R.id.surName);
        EditText state = findViewById(R.id.state);
        EditText suburb = findViewById(R.id.major);
        EditText major = findViewById(R.id.major);
        EditText phonenum = findViewById(R.id.phonenum);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = firstName.getText().toString();
                String userSurname = surName.getText().toString();
                String userState = state.getText().toString();
                String userSuburb = suburb.getText().toString();
                String userMajor = major.getText().toString();
                String userPhone = phonenum.getText().toString();

                Intent intent = new Intent(GetDetailActivity.this,MainActivity.class);
                intent.putExtra("keyname",userName);
                intent.putExtra("keysurname",userSurname);
                intent.putExtra("keystate",userState);
                intent.putExtra("keysuburb", userSuburb);
                intent.putExtra("keymajor", userMajor);
                intent.putExtra("keyphone", userPhone);
                startActivity(intent);
            }
        });

    }
}