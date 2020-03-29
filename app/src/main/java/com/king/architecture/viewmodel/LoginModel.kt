package com.king.architecture.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.king.architecture.BR

class LoginModel : BaseObservable() {

    @get:Bindable
    var account: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.account)
        }

    @get:Bindable
    var password: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

    @get:Bindable
    var remember: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.remember)
        }
}