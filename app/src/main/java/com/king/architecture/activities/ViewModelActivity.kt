package com.king.architecture.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.king.architecture.R
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityViewmodelBinding
import com.king.databindingdemo.bean.CommodityViewModel

/**
 * @author：wangzhicheng
 * @date:  2019-09-13 11:34
 * @email： wangzhicheng@lukou.com
 */
class ViewModelActivity : BaseDataBindingActivity<ActivityViewmodelBinding>() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ViewModelActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_viewmodel
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(CommodityViewModel::class.java)
        binding.commodityViewModel = viewModel
        binding.lifecycleOwner = this
    }
}