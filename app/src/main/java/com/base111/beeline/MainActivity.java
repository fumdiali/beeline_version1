package com.base111.beeline;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        // create on click item listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                //send intent to item activity
                //use if(position==0) to launch individual activity
                //Intent intent = new Intent(getApplicationContext(),SingleItemActivity.class);
                //pass image index
                //intent.putExtra("id",position);
                //startActivity(intent);

                if (position==0){
                    Intent basic = new Intent(MainActivity.this,BasicActivity.class);
                    startActivity(basic);
                }
                if (position==1){
                    //activity intent here
                }
                if (position==2){
                    //activity intent here
                }
            }
        });
    }//end of on create method

    //set options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    // define click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                //about intent here
                return true;
            case R.id.search:
                Intent web = new Intent(Intent.ACTION_VIEW);
                web.setData(Uri.parse("https://www.google.com"));
                startActivity(web);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
