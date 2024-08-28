package com.mindera.rocketscience.data.api

import com.mindera.rocketscience.data.model.company.CompanyInfoModel
import com.mindera.rocketscience.data.model.launch.LaunchModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface SpaceXApi {
    @GET("info")
    suspend fun getCompanyInfo(): CompanyInfoModel

    @GET("launches")
    fun allLaunches(): Flow<List<LaunchModel>>
}