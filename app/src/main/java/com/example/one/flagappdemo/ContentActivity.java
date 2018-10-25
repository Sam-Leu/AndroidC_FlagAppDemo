package com.example.one.flagappdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ContentActivity extends AppCompatActivity {

    FlagFragment flagFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String tag = intent.getStringExtra("flag_name");
        create_img(tag);

        flagFragment = (FlagFragment) getFragmentManager().findFragmentById(R.id.flag_fragment);
        flagFragment.set_select(tag);

    }

    public void create_img(String tag){
        ImageView img = (ImageView) findViewById(R.id.flag_img);
        int img_id = getResources().getIdentifier(tag,"drawable",getPackageName());
        img.setImageResource(img_id);

    }
}
