package com.mindera.rocketscience.di

import com.mindera.rocketscience.rx.SchedulerProvider
import com.mindera.rocketscience.rx.SchedulerProviderImpl
import com.mindera.rocketscience.viewmodel.MainDashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainDashboardViewModel(get(), get(), get(), get()) }
    single<SchedulerProvider> { SchedulerProviderImpl() }
}