package com.base111.beeline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class BasicActivity extends AppCompatActivity {

    GridView basicGrid;
    int[] imagesBasic = {
            R.drawable.numbers_image,R.drawable.greet_image,
            R.drawable.phrase_image,R.drawable.ibo_bride_crop,
            R.drawable.ibo_dance,R.drawable.ibo_pot
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        basicGrid = (GridView)findViewById(R.id.gridBasic);
        //custom adapter
        BasicAdapter basicAdapter = new BasicAdapter(getApplicationContext(),
                imagesBasic);
        basicGrid.setAdapter(basicAdapter);

        //implement on item click
        basicGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                if (position==0){
                    Intent numbers = new Intent(BasicActivity.this,NumbersBasicActivity.class);
                    startActivity(numbers);
                }
                if (position==1){
                    Intent greet = new Intent(BasicActivity.this,GreetBasicActivity.class);
                    startActivity(greet);
                }
                if (position==2){
                    Intent phrases = new Intent(BasicActivity.this,PhrasesBasicActivity.class);
                    startActivity(phrases);
                }
            }
        });
    }//end of on create method
}
