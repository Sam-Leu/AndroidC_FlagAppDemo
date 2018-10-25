package com.example.one.flagappdemo;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FlagFragment flagFragment;
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

        FragmentManager fragmentManager = getFragmentManager();
        flagFragment = (FlagFragment) fragmentManager.findFragmentById(R.id.flag_fragment);

        myList = (ListView)findViewById(R.id.lv);
        for(int i=0; i<countries.length; i++){
            flagList.add(new Item(countries[i],icons[i]));
        }

        final MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, flagList);
        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item = flagList.get(position);
                list_clicked(item.getFlagName().toLowerCase());
            }
        });

        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //定义AlertDialog.Builder对象，当长按列表项的时候弹出确认删除对话框
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Delete Item?");
                builder.setTitle("Tips");

                //添加AlertDialog.Builder对象的setPositiveButton()方法
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(flagList.remove(position)!=null){
                            Log.d("MainActivity", "deleted successfully");
                        }else {
                            Log.d("MainActivity", "deleted failed");
                            }
                        myAdapter.notifyDataSetChanged();
                        Toast.makeText(getBaseContext(), "deleted successfully", Toast.LENGTH_SHORT).show();
                    }
                });

                //添加AlertDialog.Builder对象的setNegativeButton()方法
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.create().show();
                return true;

            }
        });
    }

    /**
     * 列表点击事件处理
     * @param tag
     */
    public void list_clicked(String tag){
        Intent intent = new Intent(this,ContentActivity.class);
        intent.putExtra("flag_name",tag);
        startActivity(intent);
    }

}
