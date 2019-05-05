package com.alexis.chineseastrology.dagger.general.viewinjector

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import com.alexis.chineseastrology.IChastroActivity

interface IViewWithActivity {
    // TODO
    // Revert this back to plain Activity
    // because using activity.fragmentActivity is weird...
    val activity: IChastroActivity
        get() {
            var context = getContext()
            while (context is ContextWrapper) {
                if (context is Activity) {
                    return context as IChastroActivity
                }
                context = context.baseContext
            }
            throw IllegalStateException("Context is not from activity: $context")
        }

    fun getContext(): Context?
}