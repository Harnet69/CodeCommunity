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
import com.harnet.codecommunity.util.SwipeCardsHelper
import com.harnet.codecommunity.viewModel.TechsChooserViewModel
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class TechsChooserFragment : Fragment() {
    private lateinit var dataBinding: TechsChooserFragmentBinding
    private lateinit var viewModel: TechsChooserViewModel

    private val swipeCardsHelper = SwipeCardsHelper()

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
            context?.let {
                swipeCardsHelper.addSwipeFlingAdapter(
                    it,
                    //get only techs names
                    techsList.map { it.name } as ArrayList<String>,
                    dataBinding.swipeCardsFrame)
            }
        })
    }
}