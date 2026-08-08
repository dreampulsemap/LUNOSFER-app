package io.lunosfer.dreamap.data.network

import com.squareup.moshi.Moshi
import io.lunosfer.dreamap.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Base URL: lunosfer.com web app'inin kendisi (Next.js API route'ları burada
 * yaşıyor), Supabase URL'i DEĞİL. BuildConfig.APP_URL .env / .env.example
 * üzerinden Secrets Gradle Plugin ile enjekte edilir — web tarafındaki
 * NEXT_PUBLIC_APP_URL ile aynı konvansiyon (bkz. .env.example'a eklenen satır).
 */
object NetworkModule {

    // Not: KotlinJsonAdapterFactory (reflection) BİLİNÇLİ olarak eklenmedi.
    // build.gradle.kts'de zaten ksp(libs.moshi.kotlin.codegen) aktif ve her
    // model @JsonClass(generateAdapter = true) ile işaretli — codegen derleme
    // zamanında adapter üretir, reflection factory hem gereksiz hem daha yavaş.
    private val moshi: Moshi = Moshi.Builder().build()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .addInterceptor(loggingInterceptor)
        .connectTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.APP_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val api: LunosferApi by lazy { retrofit.create(LunosferApi::class.java) }
}
