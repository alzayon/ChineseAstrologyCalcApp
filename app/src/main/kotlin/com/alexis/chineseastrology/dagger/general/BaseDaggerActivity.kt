package com.alexis.chineseastrology.dagger.general

import android.view.View
import com.alexis.chineseastrology.dagger.general.viewinjector.IHasViewInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal abstract class BaseDaggerActivity : DaggerAppCompatActivity(), IHasViewInjector {
    @Inject
    lateinit var viewInjector: DispatchingAndroidInjector<View>

    override fun viewInjector(): AndroidInjector<View> = viewInjector
}