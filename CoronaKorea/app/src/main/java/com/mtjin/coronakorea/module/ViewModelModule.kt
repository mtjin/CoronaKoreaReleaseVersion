package com.mtjin.coronakorea.module

import com.mtjin.coronakorea.views.city.CityViewModel
import com.mtjin.coronakorea.views.country.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {
    viewModel { CountryViewModel(get()) }
    viewModel { CityViewModel(get()) }
}