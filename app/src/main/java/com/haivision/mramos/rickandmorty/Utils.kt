package com.haivision.mramos.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun String.getIdFromUrl() = this.split("/").last()

fun ViewGroup.inflate(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadUrl(url: String) {
    Picasso.get().load(url).into(this)
}
