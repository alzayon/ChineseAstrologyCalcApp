package com.alexis.chineseastrology.dagger.general.viewinjector

import android.view.View
import dagger.android.AndroidInjector

internal interface IHasViewInjector {
    fun viewInjector(): AndroidInjector<View>
}