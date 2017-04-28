package com.base111.beeline;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class PhrasesBasicActivity extends AppCompatActivity {

    //VideoView videoView;
    GridView phraseGrid;
   static final int[] phraseImage = {
            R.drawable.phrase_book_logo,R.drawable.phrases_logo,
            R.drawable.words_logo,R.drawable.proverbs_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases_basic);

        phraseGrid = (GridView)findViewById(R.id.phraseGrid);

        phraseGrid.setAdapter(new CustomAdapter(this));

        //on item click
        phraseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                if (position==0){
                    Intent phraseBook = new Intent(Intent.ACTION_VIEW);
                    phraseBook.setData(Uri.parse("http://wikitravel.org/en/Igbo_phrasebook"));
                    startActivity(phraseBook);
                }

                if(position==1){
                    Intent phrase = new Intent(Intent.ACTION_VIEW);
                    phrase.setData(Uri.parse("http://www.omniglot.com/language/phrases/igbo.php"));
                    startActivity(phrase);
                }

                if (position==2){
                    Intent word = new Intent(Intent.ACTION_VIEW);
                    word.setData(Uri.parse("http://archive.phonetics.ucla.edu/Language/IBO/ibo_conversation_1981_01.html"));
                    startActivity(word);
                }

                if (position==3){
                    Intent proverb = new Intent(Intent.ACTION_VIEW);
                    proverb.setData(Uri.parse("https://www.igboguide.org/guests/igbo-proverbs.htm"));
                    startActivity(proverb);
                }
            }
        });

        /*videoView = (VideoView)findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("https://youtu.be/2MLnLKYum2A?t=4"));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();*/
    }//end of on create method

    public class CustomAdapter extends BaseAdapter {
        private Context mContext;

        public CustomAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return phraseImage.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                //mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
                //mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(phraseImage[position]);
            return mImageView;
        }
    }




    //set options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic_phrases,menu);
        return true;
    }

    // define click events
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.phrasequiz:
                //about intent here
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
