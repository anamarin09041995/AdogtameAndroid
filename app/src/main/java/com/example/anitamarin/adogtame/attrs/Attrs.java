package com.example.anitamarin.adogtame.attrs;

import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class Attrs {

    @BindingAdapter("app:imgUrl")
    public static void setImage(ImageView img, String url){
        Picasso.with(img.getContext())
                .load(Uri.parse(url))
                .into(img);
    }


}