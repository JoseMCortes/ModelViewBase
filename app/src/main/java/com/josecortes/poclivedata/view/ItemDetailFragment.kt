package com.josecortes.poclivedata.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josecortes.androidexperimentslivedata.R
import com.josecortes.androidexperimentslivedata.databinding.FragmentDetailBinding
import com.josecortes.poclivedata.viewmodel.ItemViewModel
import com.josecortes.poclivedata.viewmodel.UserDataViewModel

/**
 * Fragment containing some basic visual information.
 *
 * In this case, the first part of the information will be created by the user interface represented
 * by the Activity (located in the UserDataViewModel). The second part of the information will
 * simulate Repository data updates through the ItemViewModel.
 *
 * Both ViewModels will be tied to the Activity lifecycle as that information will be shared together
 * with the Fragments.
 *
 * Respecting SOLID principles, two different ViewModels have been creating for Single Responsibilities
 * and increasing modularity.
 *
 * Android Data Binding has been used to receive in real-time data updates (user updated from UI either
 * Repository updates)
 */
class ItemDetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: FragmentDetailBinding? = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)
        val viewModel = ViewModelProviders.of(activity!!).get(ItemViewModel::class.java)
        val userDataViewModel = ViewModelProviders.of(activity!!).get(UserDataViewModel::class.java)

        binding?.let {
            it.viewModel = viewModel
            it.userViewModel = userDataViewModel
            it.setLifecycleOwner(this)
        }

        return binding?.root
    }

}