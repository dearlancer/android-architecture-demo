package com.king.architecture.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.ObservableInt
import android.view.View
import com.king.architecture.R
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityObservabilityBinding


/**
 * @author：wangzhicheng
 * @date:  2019-09-13 11:19
 * @email： wangzhicheng@lukou.com
 */
class ObservabilityActivity : BaseDataBindingActivity<ActivityObservabilityBinding>() {
    private val count: ObservableInt = ObservableInt(0)
    override fun getLayoutId(): Int {
        return R.layout.activity_observability
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ObservabilityActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)
        binding.countText = count
    }

    fun onLike(view: View) {
        count.increment()
    }

    private fun ObservableInt.increment() {
        set(get() + 1)
    }

}