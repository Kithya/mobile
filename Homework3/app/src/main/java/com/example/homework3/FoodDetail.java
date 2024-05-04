package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FoodDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //Receive data from previous activity
        Bundle dataBundle = getIntent().getExtras();
        String foodName = dataBundle.getString("name");
        Drawable foodImage = getResources().getDrawable(dataBundle.getInt("image"));
        //get handles to the views
        TextView foodTitle = (TextView)  findViewById(R.id.foodTextView);
        ImageView image = (ImageView)  findViewById(R.id.foodImageView);
        //set data to display in views
        foodTitle.setText(foodName);
        image.setImageDrawable(foodImage);
    }
}