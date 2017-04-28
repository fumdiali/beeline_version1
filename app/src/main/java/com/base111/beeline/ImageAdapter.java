package com.base111.beeline;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by fumnanyad on 4/26/17.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    //images in array
    public Integer[] mThumbId={
            R.drawable.abc_icon,R.drawable.mouse_icon,
            R.drawable.microscope

    };

    //constructor
    public ImageAdapter(Context context){
        mContext = context;
    }//end of constructor

    public int getCount(){
        return mThumbId.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbId[position]);
        return imageView;
    }
}
