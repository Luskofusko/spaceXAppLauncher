package com.mindera.rocketscience.data.di

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.awaitResponse
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class FlowCallAdapterFactory private constructor(): CallAdapter.Factory(){
    companion object {
        fun create() = FlowCallAdapterFactory()
    }

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Flow::class.java != getRawType(returnType)) {
            return null
        }
        check(returnType is ParameterizedType) {
            "Flow return type must be parameterized as Flow<Foo> or Flow<out Foo>"
        }

        val responseType = getParameterUpperBound(0, returnType)

        val rawDeferredType = getRawType(responseType)

        return if (rawDeferredType == Response::class.java) {
            check(responseType is ParameterizedType) {
                "Response must be parametrized as Response<Foo> or Response<out Foo>"
            }
            ResponseCallAdapter<Any>(getParameterUpperBound(0, responseType))
        } else {
            BodyCallAdapter<Any>(responseType)
        }

    }

    private class BodyCallAdapter<T : Any>(
        private val responseType: Type
    ): CallAdapter<T, Flow<T>> {
        override fun responseType() = responseType

        override fun adapt(call: Call<T>): Flow<T> = flow { emit(call.await()) }
    }

    private class ResponseCallAdapter<T: Any>(
        private val responseType: Type
    ): CallAdapter<T, Flow<Response<T>>> {
        override fun responseType() = responseType

        override fun adapt(call: Call<T>): Flow<Response<T>> = flow { emit(call.awaitResponse()) }
    }
}