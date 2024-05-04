package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputTextBox;
    Button convertButton;
    TextView convertResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextBox = findViewById(R.id.inputTextBox);
        convertButton = findViewById(R.id.convertButton);
        convertResult = findViewById(R.id.convertResult);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strFh = convertToFh(inputTextBox.getText().toString());
                convertResult.setText(strFh + "F");
            }
        });

        // Check if there is a saved state and restore it
        if (savedInstanceState != null) {
            String savedResult = savedInstanceState.getString("convertResult");
            convertResult.setText(savedResult);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("convertResult", convertResult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String savedResult = savedInstanceState.getString("convertResult");
        convertResult.setText(savedResult);
    }

    private String convertToFh(String pCelcius) {
        try {
            double c = Double.parseDouble(pCelcius);
            double f = c * (9 / 5) + 32;
            return String.format("%3.2f", f);
        } catch (NumberFormatException nfe) {
            return "Error";
        }
    }
}
