package com.mindera.rocketscience.data.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.mindera.rocketscience.data.api.SpaceXApi
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val SPACEX_API_URL = "https://api.spacexdata.com/v3/"

val apiModule = module {
    single<CallAdapter.Factory> { FlowCallAdapterFactory.create() }
    single<ObjectMapper> {
        ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
        )
    }
    single<Converter.Factory> { JacksonConverterFactory.create(get()) }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(SPACEX_API_URL)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
    }
    single<SpaceXApi> { get<Retrofit>().create(SpaceXApi::class.java) }
}