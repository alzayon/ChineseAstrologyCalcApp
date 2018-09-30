package com.alexis.chineseastrology

import android.support.v4.app.FragmentActivity
import com.alexis.chineseastrology.general.ViewModelFactory

interface IChastroActivity {
    val viewModelFactory: ViewModelFactory
    val fragmentActivity: FragmentActivity
}