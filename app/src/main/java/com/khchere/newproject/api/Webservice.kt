package com.khchere.newproject.api

import com.khchere.newproject.model.RepoSearchResponse
import com.khchere.newproject.model.UserData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Webservice{
    companion object {
        private const val BASE_URL = "https://api.github.com/"
//        private const val BASE_URL = "http://snssaradio.nexon.com/"

        fun create(): Webservice {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Webservice::class.java)
        }
    }

    @GET("search/repositories?sort=stars")
    fun searchRepos(@Query("q") query: String,
                    @Query("page") page: Int,
                    @Query("per_page") itemsPerPage: Int): Call<RepoSearchResponse>

    @FormUrlEncoded
    @POST("SAPeople/peopleDetailView.aspx")
    fun getUser(@Field("auth_code") authCode: String) : Call<UserData>



}