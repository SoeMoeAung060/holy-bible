package com.soe.holybible.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.soe.holybible.data.remote.api.BibleApi
import com.soe.holybible.data.repository.BibleRepositoryImpl
import com.soe.holybible.domain.usecase.BibleUseCases
import com.soe.holybible.domain.usecase.GetBibleBooks
import com.soe.holybible.domain.usecase.GetBibleChapters
import com.soe.holybible.domain.usecase.GetBibleSearch
import com.soe.holybible.domain.usecase.GetBibles
import com.soe.holybible.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BibleModule {


    @Provides
    @Singleton
    fun provideBibleApi() : BibleApi{
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }


        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()


        val json = Json{
            ignoreUnknownKeys = true // Ignore unknown keys
            isLenient = true // Allow lenient parsing
            coerceInputValues = true // Coerce nulls to defaults if property has a default value
        }



        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(BibleApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBibleRepository (
        bibleApi: BibleApi
    ) = BibleRepositoryImpl(bibleApi = bibleApi)


    @Provides
    @Singleton
    fun provideUseCase(
        repository: BibleRepositoryImpl
    ) = BibleUseCases(
        getBibles = GetBibles(repository),
        getBibleBooks = GetBibleBooks(repository),
        getBibleChapters = GetBibleChapters(repository),
        getBibleSearch = GetBibleSearch(repository)
    )
}