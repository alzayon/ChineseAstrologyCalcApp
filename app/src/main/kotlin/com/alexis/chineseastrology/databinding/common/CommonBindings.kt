package com.alexis.chineseastrology.databinding.common

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.alexis.chineseastrology.lib.animalsigns.IAnimalSign
import com.alexis.chineseastrology.lib.flyingstars.time.IFlyingStarGroup
import com.alexis.chineseastrology.widgets.FlyingStarCanvas
import java.util.*

object CommonBindings {
    @BindingAdapter("android:text")
    @JvmStatic
    fun TextView.androidTextBinding(date: Date) {
        val context = this.context
        val format = android.text.format.DateFormat.getDateFormat(context);
        this.text = format.format(date)
    }

    @BindingAdapter("android:onClick")
    @JvmStatic
    fun Button.androidOnClickBinding(callback: () -> IAnimalSign) {
        this.setOnClickListener {
            callback.invoke()
        }
    }

    @BindingAdapter("android:text")
    @JvmStatic
    fun EditText.androidTextBinding(anInt: Int) {
        val str = anInt.toString()
        this.setText(str)
        this.setSelection(str.length)
    }

    @InverseBindingAdapter(
            attribute = "android:text",
            event = "android:textAttrChanged"
    )
    @JvmStatic
    fun EditText.androidTextBindingInverse_Int(): Int {
        val str = this.text.toString()
        if (str.isNullOrBlank()) return 0
        return Integer.parseInt(str)
    }

    @BindingAdapter("flyingStarGroup")
    @JvmStatic
    fun FlyingStarCanvas.flyingStarGroupBinding(flyingStarGroup: IFlyingStarGroup?) {
        this.flyingStarGroup = flyingStarGroup
    }
}