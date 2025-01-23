package com.hossein.dev.newsapp.di

import android.app.Application
import com.hossein.dev.newsapp.data.manager.LocalUserManagerImpl
import com.hossein.dev.newsapp.domain.manager.LocalUserManager
import com.hossein.dev.newsapp.domain.usecases.AppEntryUseCases
import com.hossein.dev.newsapp.domain.usecases.ReadAppEntry
import com.hossein.dev.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}