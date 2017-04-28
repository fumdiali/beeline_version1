package com.base111.beeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by fumnanyad on 4/27/17.
 */
public class BasicAdapter extends BaseAdapter {

    Context context;
    int[] imagesBasic;
    LayoutInflater inflater;

    public BasicAdapter(Context appContext,int[] imagesBasic){
        this.context = appContext;
        this.imagesBasic = imagesBasic;
        inflater = (LayoutInflater.from(appContext));
    }

    @Override
    public int getCount(){
        return imagesBasic.length;
    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View view,
                        ViewGroup viewGroup){
        view = inflater.inflate(R.layout.basic_grid_layout,null);

        ImageView imageViewBasic = (ImageView)view.findViewById(R.id.imageViewbasic);
        imageViewBasic.setImageResource(imagesBasic[position]);
        return view;
    }
}
