package com.patan.commerce.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewModelsModule {

    @Provides
    @Singleton
    @TokenQualifier
    fun provideToken(@ApplicationContext context: Context): String {
        return context.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
            .getString("token", "default") ?: ""
    }

    @Provides
    @Singleton
    @UserIdQualifier
    fun provideUserId(@ApplicationContext context: Context): String {
        return context.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)
            .getString("userId", "default") ?: ""
    }
}
