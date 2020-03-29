package com.king.architecture.utils

import android.os.Build
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.ListenerUtil
import androidx.databinding.adapters.ViewBindingAdapter
import com.king.architecture.R

/**
 * @author：wangzhicheng
 * @date:  2019-09-14 16:03
 * @email： wangzhicheng@lukou.com
 */
object BindingAdapterUtil {
    @JvmStatic
    @BindingAdapter("android:paddingLeft")
    fun setPaddingLeft(view: View, oldPadding: Int, newPadding: Int) {
        if (oldPadding != newPadding) {
            view.setPadding(
                newPadding,
                view.paddingTop,
                view.paddingRight,
                view.paddingBottom
            )
        }
    }
    @JvmStatic
    @BindingAdapter(
        "android:onViewDetachedFromWindow",
        "android:onViewAttachedToWindow",
        requireAll = false
    )
    fun setListener(
        view: View,
        detach: ViewBindingAdapter.OnViewDetachedFromWindow?,
        attach: ViewBindingAdapter.OnViewAttachedToWindow?
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            val newListener: View.OnAttachStateChangeListener?
            newListener = if (detach == null && attach == null) {
                null
            } else {
                object : View.OnAttachStateChangeListener {
                    override fun onViewAttachedToWindow(v: View) {
                        attach?.onViewAttachedToWindow(v)
                    }

                    override fun onViewDetachedFromWindow(v: View) {
                        detach?.onViewDetachedFromWindow(v)
                    }
                }
            }

            val oldListener: View.OnAttachStateChangeListener? =
                ListenerUtil.trackListener(view, newListener, R.id.onAttachStateChangeListener)
            if (oldListener != null) {
                view.removeOnAttachStateChangeListener(oldListener)
            }
            if (newListener != null) {
                view.addOnAttachStateChangeListener(newListener)
            }
        }
    }
}