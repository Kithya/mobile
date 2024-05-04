package com.example.homework5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //data source
    //List for location data
    private List<Location> loadData () {
        List<Location> locations = new ArrayList<Location>();
        locations.add(new Location("phnompenh",11.5564,104.9282, R.drawable.phnompenh));
        locations.add(new Location("sihanoukville", 10.627543,103.522141, R.drawable.preahsihanouk));
        locations.add(new Location("kampot",10.594242,104.164032, R.drawable.kampot));
        locations.add(new Location("siemreap",13.364047,103.860313, R.drawable.siemreap));
        locations.add(new Location("battambang",13.028697,102.989616, R.drawable.battambang));
        locations.add(new Location("kampongcham",11.99339,105.4635, R.drawable.kampongcham));
        locations.add(new Location("kampongchnang",12.25,104.66667, R.drawable.kampongchhnang));
        locations.add(new Location("kampongthom",12.71112,104.88873, R.drawable.kampongthom));
        locations.add(new Location("kohkong",11.61531,102.9838, R.drawable.kohkong));
        locations.add(new Location("kep",10.48291,104.31672, R.drawable.kep));
        locations.add(new Location("preyveng",11.48682,105.32533, R.drawable.preyveng));
        locations.add(new Location("takeo",10.99081,104.78498, R.drawable.takeo));
        locations.add(new Location("pursat",12.53878,103.9192, R.drawable.pursat));
        locations.add( new Location("mondulkiri", 12.45583,107.18811, R.drawable.mondulkiri));
        locations.add( new Location("stungtreng",13.52586,105.9683, R.drawable.stungtreng));
        locations.add( new Location("svayrieng", 11.08785,105.79935, R.drawable.svayrieng));
        locations.add( new Location("preahvihear",13.80731,104.98046, R.drawable.preahvihear));
        locations.add(new Location("kandal",11.48333,104.95, R.drawable.kandal));
        locations.add( new Location("banteayMeanchey",13.58588,102.97369, R.drawable.banteay_meanchey));
        locations.add( new Location("ratanakiri", 13.73939,106.98727, R.drawable.ratanakiri));
        locations.add( new Location("kampongspeu",11.45332,104.52085, R.drawable.kampongspeu));
        locations.add(new Location("kratie",12.48811,106.01879, R.drawable.kratie));
        locations.add(new Location("pailin", 12.84895,102.60928, R.drawable.pailin));
        locations.add(new Location("oddarmeanchey",14.18175,103.51761, R.drawable.oddarmeanchey));
        locations.add(new Location("tbongkmoum", 11.8891,105.8760, R.drawable.tboungkhmum));
        return locations;
    }

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect to listview
        list=(ListView) findViewById(R.id.listView);

        List locations=loadData();
//        ArrayAdapter<String> adapter;
//        adapter=new ArrayAdapter<String>( this,
//                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                locations);

        CustomeListAdapter adapter=new CustomeListAdapter(this, locations);

        list.setAdapter(adapter);

        //handle listview event listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Location selectedItem=(Location) list.getItemAtPosition(i);

                //Toast.makeText(getApplicationContext(), selectedItem.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle dataBundle = new Bundle();
                dataBundle.putString("item_name", selectedItem.getName());
                dataBundle.putInt("item_image", selectedItem.getImage());
                dataBundle.putDouble("item_lat", selectedItem.getLatitude());
                dataBundle.putDouble("item_long", selectedItem.getLongtitude());

                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch(item.getItemId()){
//            case R.id.addMenu:
//                showAddNew();
//                return true;
//            case R.id.settingMenu:
//                showSetting();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//
//    }
    private void showAddNew(){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }

    private void showSetting(){
        Toast toast=Toast.makeText(getApplicationContext(),"Clicked setting menu", Toast.LENGTH_LONG);
        toast.show();
    }
}