package com.alexis.chineseastrology.dagger.general.viewinjector

import android.view.View
import dagger.MapKey
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewKey(val value: KClass<out View>)