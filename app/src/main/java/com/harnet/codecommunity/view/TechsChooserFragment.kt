package com.harnet.codecommunity.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.TechsChooserFragmentBinding
import com.harnet.codecommunity.di.DaggerSwipeCardsHelperComponent
import com.harnet.codecommunity.util.SwipeCardsHelper
import com.harnet.codecommunity.viewModel.TechsChooserViewModel
import javax.inject.Inject

class TechsChooserFragment : Fragment() {
    private lateinit var dataBinding: TechsChooserFragmentBinding
    private lateinit var viewModel: TechsChooserViewModel

    @Inject
    lateinit var swipeCardsHelper: SwipeCardsHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.techs_chooser_fragment, container, false)
        viewModel = ViewModelProvider(this).get(TechsChooserViewModel::class.java)

        // inject cards swiper helper
        DaggerSwipeCardsHelperComponent.create().inject(this)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refresh()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.mTechsList.observe(viewLifecycleOwner,{ techsList ->
            context?.let {
                swipeCardsHelper.addSwipeFlingAdapter(
                    it,
                    //get only techs names
                    techsList.map { tech -> tech.name } as ArrayList<String>,
                    dataBinding.swipeCardsFrame)
            }
        })
    }
}