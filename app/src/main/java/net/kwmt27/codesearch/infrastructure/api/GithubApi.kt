package net.kwmt27.codesearch.infrastructure.api

import io.reactivex.Single
import net.kwmt27.codesearch.infrastructure.entity.EventEntity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


interface GithubApi {

    companion object {

        private const val BASE_URL = "https://api.github.com/"
        fun create(): GithubApi {
            val logger = HttpLoggingInterceptor().apply {
                HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create(GithubApi::class.java)
        }
    }

    @GET("users/{user}/received_events")
    fun fetchEvent(@Path("user") user: String, @Query("page") page: Int): Single<List<EventEntity>>

    @POST("/authorizations")
    fun authorizations(
            @Field("scopes") scopes: List<String>,
            @Field("note") note: String,
            @Field("note_ur") noteUr: String

    ): Single<String>
}
