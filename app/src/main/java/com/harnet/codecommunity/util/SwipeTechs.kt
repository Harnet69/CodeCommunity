package com.harnet.codecommunity.util

import android.util.Log
import com.harnet.codecommunity.model.Swiper

const val TAG = "SwipeTechs"

class SwipeTechs: Swiper() {
    override fun swipeLeft() {
        Log.i(TAG, "swipeLeft: ")
    }

    override fun swipeRight() {
        Log.i(TAG, "swipeRight: ")
    }

    override fun click() {
        Log.i(TAG, "click: ")
    }

    override fun empty() {
        Log.i(TAG, "empty: ")
    }

}