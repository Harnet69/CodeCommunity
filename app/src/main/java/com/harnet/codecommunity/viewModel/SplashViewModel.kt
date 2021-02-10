package com.harnet.codecommunity.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.harnet.codecommunity.view.SplashFragmentDirections
import kotlinx.coroutines.*

class SplashViewModel : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun redirect(view: View) {
        coroutineScope.launch {
            delay(2000)
            coroutineScope.launch(Dispatchers.Main) {
                Navigation.findNavController(view)
                    .navigate(SplashFragmentDirections.actionSplashFragment3ToStartupFragment())
            }
        }
    }
}