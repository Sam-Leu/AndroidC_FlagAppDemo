package com.example.one.flagappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
    private ListView myList;
    ArrayList<Item> flagList = new ArrayList<>();

    //数据集合
    private String[] countries = {"Algeria","Aruba","Austria","Chile","China","Colombia","Denmark","Dominica","Ecuador","France"};

    //图片集合
    private  int[] icons = {R.drawable.algeria,R.drawable.aruba,R.drawable.austria,R.drawable.chile,R.drawable.china,R.drawable.colombia,R.drawable.denmark,R.drawable.dominica,R.drawable.ecuador,R.drawable.france};


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = (ListView)findViewById(R.id.lv);
        for(int i=0; i<countries.length; i++){
            flagList.add(new Item(countries[i],icons[i]));
        }
//        flagList.add(new Item(countries[0],icons[0]));
//        flagList.add(new Item(countries[1],icons[1]));
//        flagList.add(new Item(countries[2],icons[2]));
//        flagList.add(new Item(countries[3],icons[3]));
//        flagList.add(new Item(countries[4],icons[4]));
//        flagList.add(new Item(countries[5],icons[5]));
//        flagList.add(new Item(countries[6],icons[6]));
//        flagList.add(new Item(countries[7],icons[7]));
//        flagList.add(new Item(countries[8],icons[8]));
//        flagList.add(new Item(countries[9],icons[9]));

        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, flagList);
        myList.setAdapter(myAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
