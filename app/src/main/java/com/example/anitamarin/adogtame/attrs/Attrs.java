package com.example.anitamarin.adogtame.attrs;

import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class Attrs {

    @BindingAdapter("app:customFont")
    public void setFont(TextView txt, String name) {
        AssetManager manager = txt.getContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(manager, "fonts"+name+".ttf");
        txt.setTypeface(typeface);
    }
}