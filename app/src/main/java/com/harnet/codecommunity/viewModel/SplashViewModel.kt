package com.harnet.codecommunity.viewModel

import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.harnet.codecommunity.view.SplashFragmentDirections
import kotlinx.coroutines.*


class SplashViewModel : ViewModel() {
    private val duration = 1500L
    private val rotationDelay = duration /10
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun redirect(imageView: ImageView) {
        coroutineScope.launch {
            delay(duration - rotationDelay)
            rotateImg(imageView)
            delay(duration)
            coroutineScope.launch(Dispatchers.Main) {
                Navigation.findNavController(imageView)
                    .navigate(SplashFragmentDirections.actionSplashFragment3ToStartupFragment())
            }
        }
    }

    private fun rotateImg(imageView: ImageView) {
        val animSet = AnimationSet(true)
        animSet.interpolator = DecelerateInterpolator()
        animSet.fillAfter = true
        animSet.isFillEnabled = true

        val animRotate = RotateAnimation(
            0.0f, 360.0f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )

        animRotate.duration = duration - rotationDelay
        animRotate.fillAfter = true
        animSet.addAnimation(animRotate)

        imageView.startAnimation(animSet)
    }
}