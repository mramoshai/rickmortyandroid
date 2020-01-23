package com.haivision.mramos.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadUrl(url: String) = Picasso.get().load(url).into(this)

fun RecyclerView.isLastItemFullyVisible(): Boolean {
    val items = layoutManager?.itemCount
    val first = items?.minus(1)?.let { layoutManager?.findViewByPosition(it) }
    val isPartially = first?.let { layoutManager?.isViewPartiallyVisible(it, true, false) }
    isPartially?.let { return isPartially }
    return false
}

fun RecyclerView.onEndScroll(run: () -> Unit) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (isLastItemFullyVisible()) run()
        }
    })
}
