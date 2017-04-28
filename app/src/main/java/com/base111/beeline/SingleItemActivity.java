package com.base111.beeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SingleItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_item);

        //get intent data
        Intent intent = getIntent();

        //select image id
        int position = intent.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView)findViewById(R.id.singleItem);
        imageView.setImageResource(imageAdapter.mThumbId[position]);
    }// end of on create method
}
