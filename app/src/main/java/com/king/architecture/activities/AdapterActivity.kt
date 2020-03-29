package com.king.architecture.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.adapters.ViewBindingAdapter
import com.king.architecture.R
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityAdapterBinding
import com.king.databindingdemo.bean.User

/**
 * @author：wangzhicheng
 * @date:  2019-09-13 11:32
 * @email： wangzhicheng@lukou.com
 */
class AdapterActivity : BaseDataBindingActivity<ActivityAdapterBinding>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, AdapterActivity::class.java)
            context.startActivity(intent)
        }
    }

    lateinit var text: String
    override fun getLayoutId(): Int {
        return R.layout.activity_adapter
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)
        binding.user = User("小可爱", "110", true, "hello world")
        binding.onViewAttachedToWindow = ViewBindingAdapter.OnViewAttachedToWindow { v ->
            Toast.makeText(v.context,
                String.format("%s attach", v.javaClass.name),Toast.LENGTH_SHORT).show()
        }
        binding.onViewDetachedFromWindow = ViewBindingAdapter.OnViewDetachedFromWindow { v ->
            Toast.makeText(v.context,
                String.format("%s detach", v.javaClass.name),Toast.LENGTH_SHORT).show()
        }
    }
}