package com.example.weatherapp.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.setImage(url:String){
Picasso.get().load(url).into(this)
}