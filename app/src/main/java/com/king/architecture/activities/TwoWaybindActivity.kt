package com.king.architecture.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.king.architecture.R
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityTwoWayBindBinding
import com.king.architecture.viewmodel.LoginModel

/**
 * @author：wangzhicheng
 * @date:  2019-09-16 10:02
 * @email： wangzhicheng@lukou.com
 */
class TwoWaybindActivity : BaseDataBindingActivity<ActivityTwoWayBindBinding>() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, TwoWaybindActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_two_way_bind
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)
        binding.loginModel = LoginModel()
//        binding.loginModelBind = LoginModelBind()
    }
}