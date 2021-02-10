package com.harnet.codecommunity.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.solver.widgets.Helper
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.harnet.codecommunity.R

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.i("dfgdfg", "onViewCreated: Start")
        Handler().postDelayed({
            Navigation.findNavController(view)
                .navigate(SplashFragmentDirections.actionSplashFragment3ToStartupFragment())
        }, 2000)
        Log.i("dfgdfg", "onViewCreated: Done")
    }
}