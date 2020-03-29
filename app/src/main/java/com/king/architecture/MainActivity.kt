package com.king.architecture

import android.os.Bundle
import android.view.View
import com.king.architecture.activities.*
import com.king.architecture.base.BaseDataBindingActivity
import com.king.architecture.databinding.ActivityMainBinding

class MainActivity : BaseDataBindingActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        binding.handlers = ClickHandlers()
    }


    class ClickHandlers {
        fun onNormalUseClick(view: View) {
            NormalUseActivity.start(view.context)
        }

        fun onObservabilityClick(view: View) {
            ObservabilityActivity.start(view.context)
        }

        fun onAdapterClick(view: View) {
            AdapterActivity.start(view.context)
        }

        fun onViewModelClick(view: View) {
            ViewModelActivity.start(view.context)
        }

        fun onTwoWayBindClick(view: View) {
            TwoWaybindActivity.start(view.context)
        }
    }
}
