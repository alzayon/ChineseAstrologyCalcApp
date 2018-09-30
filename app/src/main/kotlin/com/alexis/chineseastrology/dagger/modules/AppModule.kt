package com.alexis.chineseastrology.dagger.modules

import com.alexis.chineseastrology.ChastroApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule(private val chastroApp: ChastroApplication) {
    @Provides
    @Singleton
    fun provideApp(): ChastroApplication = chastroApp
}