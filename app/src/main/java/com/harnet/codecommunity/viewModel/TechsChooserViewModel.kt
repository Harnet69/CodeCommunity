package com.harnet.codecommunity.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harnet.codecommunity.model.Technology
import kotlinx.coroutines.*

class TechsChooserViewModel : ViewModel() {
    val mTechsList = MutableLiveData<ArrayList<Technology>>()
    val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun refresh() {
        getTechsFromDb()
    }

    private fun getTechsFromDb() {
        coroutineScope.launch {
            delay(1000L)
            val techsList = arrayListOf<Technology>(
                Technology(0, "PHP", 3),
                Technology(1, "Java", 2),
                Technology(2, "C#", 1),
                Technology(3, "Python", 2)
            )
            coroutineScope.launch(Dispatchers.Main) {
                mTechsList.value = techsList
            }
        }
    }

}