package com.mtjin.coronakorea.module

import com.mtjin.coronakorea.utils.NetworkManager
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {
    single { NetworkManager(get()) }
}