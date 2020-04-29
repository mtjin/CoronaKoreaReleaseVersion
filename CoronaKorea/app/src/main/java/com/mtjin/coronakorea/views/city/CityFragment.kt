package com.mtjin.coronakorea.views.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mtjin.coronakorea.R
import com.mtjin.coronakorea.databinding.FragmentCityBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CityFragment : Fragment() {
    private lateinit var binding: FragmentCityBinding
    private val viewModel: CityViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}