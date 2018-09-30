package com.alexis.chineseastrology.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.alexis.chineseastrology.R
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import kotlinx.android.synthetic.main.birthday_result.view.*

class BirthdayResult : LinearLayout {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)  {
        init()
    }

    var value: IAnimalSign? = null
        get() = field
        set(value) {
            field = value
            updateViews()
        }

    private fun init() {
        View.inflate(context, R.layout.birthday_result, this)
    }

    private fun updateViews() {
        value?.let {
            txtAnimalSign.text = it.name
            txtElementSign.text = it.element.name.capitalize()
        }
    }
}