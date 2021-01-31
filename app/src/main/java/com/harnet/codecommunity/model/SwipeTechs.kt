package com.harnet.codecommunity.model

import android.util.Log
import com.harnet.codecommunity.model.Swiperable
import javax.inject.Inject

const val TAG = "SwipeTechs"

class SwipeTechs @Inject constructor(): Swiperable {
    override fun swipeLeft() {
        Log.i(TAG, "Tech was swiped Left: ")
    }

    override fun swipeRight() {
        Log.i(TAG, "Tech was swiped Right: ")
    }

    override fun click() {
        Log.i(TAG, "Tech was clicked: ")
    }

    override fun empty() {
        Log.i(TAG, "Tech is empty: ")
    }
}