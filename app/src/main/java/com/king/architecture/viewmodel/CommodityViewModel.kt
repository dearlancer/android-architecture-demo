package com.king.databindingdemo.bean

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author：wangzhicheng
 * @date:  2019-09-13 14:29
 * @email： wangzhicheng@lukou.com
 */
class CommodityViewModel : ViewModel() {

    private val _count: MutableLiveData<Int> = MutableLiveData()
    private val price = 123

    init {
        _count.value = 0
    }

    val count: LiveData<Int> = _count

    fun onAdd() {
        _count.value = (_count.value ?: 0) + 1
    }

    val totalPrice: LiveData<Int> = Transformations.map(_count) {
        _count.value?.times(price)
    }
}