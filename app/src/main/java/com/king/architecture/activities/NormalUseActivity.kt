package com.king.architecture.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.king.architecture.R
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityNormalUseBinding
import com.king.databindingdemo.bean.User

/**
 * @author：wangzhicheng
 * @date:  2019-09-12 16:34
 * @email： wangzhicheng@lukou.com
 */

class NormalUseActivity : BaseDataBindingActivity<ActivityNormalUseBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_normal_use
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NormalUseActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)
        binding.list = listOf("one", "two", "three", "four")
        binding.user = User("皮卡丘", "123456789", false,"这是一只非常可爱的猫咪呀")

    }
}