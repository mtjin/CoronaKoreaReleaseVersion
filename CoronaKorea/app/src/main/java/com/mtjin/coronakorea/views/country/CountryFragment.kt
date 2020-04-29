package com.mtjin.coronakorea.views.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mtjin.coronakorea.R
import com.mtjin.coronakorea.databinding.FragmentCountryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private val viewModel: CountryViewModel by viewModel()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.requestCountry()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}