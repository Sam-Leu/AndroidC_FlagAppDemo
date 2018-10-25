package com.example.one.flagappdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FlagFragment extends Fragment {

    private View view;

    public FlagFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_flag,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void set_select(String flag_name){
        TextView name = view.findViewById(R.id.flag_name);
        String str = flag_name.substring(0, 1).toUpperCase() + flag_name.substring(1);
        name.setText(str);
    }
}
