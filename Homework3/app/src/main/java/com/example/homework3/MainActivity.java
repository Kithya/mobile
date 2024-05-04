package com.example.homework3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void fruitBtnClickHandler(View v){
        showFoodView("Fruit", R.drawable.img_1);
    }
    public void vegBtnClickHandler(View v){
        showFoodView("Vegetable", R.drawable.img_3);
    }
    public void drinkBtnClickHandler(View v){
        showFoodView("Drinks", R.drawable.img_2);
    }
    private void showFoodView(String foodName, int drawableImage){
        //Store data to bundle
        Bundle dataBundle = new Bundle();
        dataBundle.putString("name",foodName);
        dataBundle.putInt("image",drawableImage);
        //Start the activity
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), com.example.homework3.FoodDetail.class); // from current activity to new activity
        intent. putExtras(dataBundle);

        startActivity(intent);

    }

    public void callBtnListener(View v){
        Uri number = Uri.parse("tel:012717261");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void webBtnListener(View v){
        Uri webpage = Uri.parse("https://www.limkokwing.net/cambodia/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

}