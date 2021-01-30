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

class TechsChooserFragment : Fragment() {
    private lateinit var dataBinding: TechsChooserFragmentBinding
    private lateinit var viewModel: TechsChooserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.techs_chooser_fragment, container, false)
        viewModel = ViewModelProvider(this).get(TechsChooserViewModel::class.java)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.textTest.text = "I'm binded!"
    }
}