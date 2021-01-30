package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.TechsChooserFragmentBinding
import com.harnet.codecommunity.viewModel.TechsChooserViewModel
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class TechsChooserFragment : Fragment() {
    private lateinit var dataBinding: TechsChooserFragmentBinding
    private lateinit var viewModel: TechsChooserViewModel

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

        //add the view via xml or programmatically
        val flingContainer = dataBinding.swipeCardsFrame


//        al = new ArrayList < String >();
//        al.add("php");
//        al.add("c");
//        al.add("python");
//        al.add("java");
//
//        //choose your favorite adapter
//        arrayAdapter = new ArrayAdapter < String >(this, R.layout.item, R.id.helloText, al);
//
//        //set the listener and the adapter
//        flingContainer.setAdapter(arrayAdapter);
//        flingContainer.setFlingListener(new SwipeFlingAdapterView . onFlingListener () {
//            @Override
//            public void removeFirstObjectInAdapter() {
//                // this is the simplest way to delete an object from the Adapter (/AdapterView)
//                Log.d("LIST", "removed object!");
//                al.remove(0);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onLeftCardExit(Object dataObject) {
//                //Do something on the left!
//                //You also have access to the original object.
//                //If you want to use it just cast it (String) dataObject
//                Toast.makeText(MyActivity.this, "Left!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onRightCardExit(Object dataObject) {
//                Toast.makeText(MyActivity.this, "Right!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAdapterAboutToEmpty(int itemsInAdapter) {
//                // Ask for more data here
//                al.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter.notifyDataSetChanged();
//                Log.d("LIST", "notified");
//                i++;
//            }
//        });
//
//        // Optionally add an OnItemClickListener
//        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView . OnItemClickListener () {
//            @Override
//            public void onItemClicked(int itemPosition, Object dataObject) {
//                makeToast(MyActivity.this, "Clicked!");
//            }
//        });
    }
}