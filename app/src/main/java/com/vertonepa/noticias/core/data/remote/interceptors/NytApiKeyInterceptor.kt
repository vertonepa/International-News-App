package com.vertonepa.noticias.core.data.remote.interceptors

import com.vertonepa.noticias.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NytApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url.newBuilder().addQueryParameter(
            "api-key",
            BuildConfig.NEWS_APIKEY
        ).build()
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }
}