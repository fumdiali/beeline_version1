package com.base111.beeline;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class NumbersBasicActivity extends AppCompatActivity {

    Button prev;
    Button next;
    TextView numsDisplay;
    int counter = 0;

    final String[] numbers = {
            "ONE - OFU","TWO - AABUO","THREE - AATO",
            "FOUR - AANOO","FIVE - IISAY"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_basic);

        prev=(Button)findViewById(R.id.prev);
        next=(Button)findViewById(R.id.next);
        numsDisplay=(TextView)findViewById(R.id.numsDisplay);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                //if counter is at array end,set it to 1st item
                if (counter == numbers.length) counter=4;
                numsDisplay.setText(numbers[counter]);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                //if counter is at array end,set it to 1st item
                if (counter < 1) counter= 0;
                    numsDisplay.setText(numbers[counter]);

            }
        });
    }//end of on create method

    //set options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic_num,menu);
        return true;
    }

    // define click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.numquiz:
                //about intent here
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
