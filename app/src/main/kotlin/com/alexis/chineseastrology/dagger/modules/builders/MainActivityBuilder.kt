package com.alexis.chineseastrology.dagger.modules.builders

import com.alexis.chineseastrology.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilder {
    @ContributesAndroidInjector()
    internal abstract fun bindMainActivity(): MainActivity
}