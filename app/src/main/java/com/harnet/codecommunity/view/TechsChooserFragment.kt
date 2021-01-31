package com.harnet.codecommunity.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.TechsChooserFragmentBinding
import com.harnet.codecommunity.viewModel.TechsChooserViewModel
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class TechsChooserFragment : Fragment() {
    private lateinit var dataBinding: TechsChooserFragmentBinding
    private lateinit var viewModel: TechsChooserViewModel

    private var arrayAdapter: ArrayAdapter<String>? = null
    private var i = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.techs_chooser_fragment, container, false)
        viewModel = ViewModelProvider(this).get(TechsChooserViewModel::class.java)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refresh()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.mTechsList.observe(viewLifecycleOwner, Observer { techsList ->
            Log.i("Technologies", "observeViewModel: $techsList")
            //get only techs names
            addSwipeFlingAdapter(techsList.map { it.name } as ArrayList<String>)
        })
    }

    private fun addSwipeFlingAdapter(techsNamesList: ArrayList<String>) {
        //add the view via xml or programmatically
        val flingContainer = dataBinding.swipeCardsFrame

        //choose your favorite adapter
        arrayAdapter =
            context?.let { ArrayAdapter(it, R.layout.item_tech, R.id.tech_name, techsNamesList) }

//        //set the listener and the adapter
        flingContainer.adapter = arrayAdapter
        flingContainer.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
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
            }
        })

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(SwipeFlingAdapterView.OnItemClickListener { i, any ->
            Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
        })
    }
}