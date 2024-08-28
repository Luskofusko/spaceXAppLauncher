package com.mindera.rocketscience.data.di

import com.mindera.rocketscience.data.repository.AllLaunchesRepositoryImpl
import com.mindera.rocketscience.data.repository.CompanyInfoRepositoryImpl
import com.mindera.rocketscience.domain.repository.AllLaunchesRepository
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CompanyInfoRepository> { CompanyInfoRepositoryImpl(get()) }
    single<AllLaunchesRepository> { AllLaunchesRepositoryImpl(get()) }

}