package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView nameView;
    ImageView cityImg;

    TextView latView;
    TextView longView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameView = (TextView) findViewById(R.id.provinceName);
        cityImg = (ImageView) findViewById(R.id.provinceImage);
        latView = (TextView) findViewById(R.id.textView4);
        longView = (TextView) findViewById(R.id.textView5);


        Bundle bundle = getIntent().getExtras();
        String itemName = bundle.getString("item_name");
        @SuppressLint("UseCompatLoadingForDrawables") Drawable cityImgs = getResources().getDrawable(bundle.getInt("item_image"));
        Double item_lat = bundle.getDouble("item_lat");
        Double item_long = bundle.getDouble("item_long");

        nameView.setText(itemName);
        cityImg.setImageDrawable(cityImgs);
        latView.setText(item_lat + "");
        longView.setText(item_long + "");

    }
}