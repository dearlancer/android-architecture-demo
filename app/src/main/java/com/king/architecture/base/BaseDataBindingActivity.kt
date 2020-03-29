package com.king.architecture.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDataBindingActivity<DB : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: DB
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootView: View = LayoutInflater.from(this).inflate(getLayoutId(), null, false)
        binding = DataBindingUtil.bind(rootView)!!
        setContentView(rootView)
        onCreated(savedInstanceState)
    }

    protected open fun onCreated(savedInstanceState: Bundle?) {

    }

    @LayoutRes
    abstract fun getLayoutId(): Int

}