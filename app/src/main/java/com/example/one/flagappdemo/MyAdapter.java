package com.example.one.flagappdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter  extends ArrayAdapter<Item> {

    ArrayList<Item> flagList = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourseId, ArrayList<Item> objects){
        super(context, textViewResourseId, objects);
        flagList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item,null);
        TextView tv = (TextView)view.findViewById(R.id.textView);
        ImageView iv = (ImageView)view.findViewById(R.id.imageView);
        tv.setText(flagList.get(position).getFlagName());
        iv.setImageResource(flagList.get(position).getFlagImage());
        return view;
    }
}
