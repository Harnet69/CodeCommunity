package com.harnet.codecommunity.util

import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.harnet.codecommunity.R
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class SwipeCardsHelper {
    private var arrayAdapter: ArrayAdapter<String>? = null
    private var i = 0

    fun addSwipeFlingAdapter(
        context: Context,
        techsNamesList: ArrayList<String>,
        flingContainer: SwipeFlingAdapterView
    ) {
        //choose your favorite adapter
        arrayAdapter = ArrayAdapter(context, R.layout.item_tech, R.id.tech_name, techsNamesList)

//        //set the listener and the adapter
        flingContainer.adapter = arrayAdapter

        flingContainer.setBackgroundColor(0xFFFFFFFF.toInt())

        arrayAdapter?.notifyDataSetChanged()

        flingContainer.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("Technologies", "removed object!");
                techsNamesList.removeAt(0);
                arrayAdapter?.notifyDataSetChanged();
            }

            override fun onLeftCardExit(p0: Any?) {
                //Do something on the left!
//                //You also have access to the original object.
//                //If you want to use it just cast it (String) dataObject
                Toast.makeText(context, "Left!", Toast.LENGTH_SHORT).show();
            }

            override fun onRightCardExit(p0: Any?) {
                Toast.makeText(context, "Right!", Toast.LENGTH_SHORT).show();
            }

            override fun onAdapterAboutToEmpty(p0: Int) {
                // Ask for more data here
                techsNamesList.add("XML $i")
                arrayAdapter?.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            override fun onScroll(p0: Float) {
                // scroll
            }
        })

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(SwipeFlingAdapterView.OnItemClickListener { i, any ->
            Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
        })
    }
}