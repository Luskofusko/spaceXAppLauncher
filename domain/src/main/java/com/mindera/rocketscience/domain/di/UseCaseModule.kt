package com.mindera.rocketscience.domain.di

import com.mindera.rocketscience.domain.usecase.AllLaunchesUseCase
import com.mindera.rocketscience.domain.usecase.AllLaunchesUseCaseImpl
import com.mindera.rocketscience.domain.usecase.GetCompanyInfoUseCase
import com.mindera.rocketscience.domain.usecase.GetCompanyInfoUseCaseImpl
import com.mindera.rocketscience.domain.usecase.GetCurrentTimeInMillisUseCase
import com.mindera.rocketscience.domain.usecase.GetCurrentTimeInMillisUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetCompanyInfoUseCase> { GetCompanyInfoUseCaseImpl(get()) }
    single<AllLaunchesUseCase> { AllLaunchesUseCaseImpl(get()) }
    single<GetCurrentTimeInMillisUseCase> { GetCurrentTimeInMillisUseCaseImpl() }
}