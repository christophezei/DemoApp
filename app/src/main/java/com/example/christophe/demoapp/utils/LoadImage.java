package com.example.christophe.demoapp.utils;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.christophe.demoapp.R;

public class LoadImage {
    public void loadImageByinternetUrl(Context context, String url, ImageView image){
        Glide
                .with(context)
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher))
                .into(image);



    }
}
