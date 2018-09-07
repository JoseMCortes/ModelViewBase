package com.josecortes.poclivedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle

class UserDataViewModel : BundledViewModel, ViewModel() {

    companion object {
        const val USER_DATA = "key:USER_DATA"
    }

    val userData = MutableLiveData<String>()

    fun setData(data: String?) {
        if (data != null)
            userData.postValue(data)
    }

    override fun writeTo(bundle: Bundle?) {
        // Save here only necessary and light information to be restored
        bundle?.putString(USER_DATA, userData.value)
    }

    override fun readFrom(bundle: Bundle?) {
        val userData = bundle?.getString(USER_DATA)
        setData(userData)
    }

}