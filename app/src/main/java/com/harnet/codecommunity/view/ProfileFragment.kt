package com.harnet.codecommunity.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.harnet.codecommunity.viewModel.ProfileViewModel
import com.harnet.codecommunity.R
import com.harnet.codecommunity.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {
    private lateinit var viewModel: ProfileViewModel
    private lateinit var dataBinding: ProfileFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.logOutProfile.setOnClickListener {
            viewModel.logOut()
            Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
     viewModel.mIsUserLogged.observe(viewLifecycleOwner, {isUserLogged ->
         if(!isUserLogged){
             Navigation.findNavController(dataBinding.logOutProfile).navigate(ProfileFragmentDirections.actionProfileFragmentToStartupFragment())
         }
     })
    }
}