package com.alexis.chineseastrology

import androidx.fragment.app.FragmentActivity
import com.alexis.chineseastrology.general.ViewModelFactory

interface IChastroActivity {
    val viewModelFactory: ViewModelFactory
    val fragmentActivity: FragmentActivity
}