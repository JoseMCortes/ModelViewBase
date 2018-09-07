package com.josecortes.poclivedata.viewmodel

import android.os.Bundle

interface BundledViewModel {
    fun writeTo(bundle: Bundle?)
    fun readFrom(bundle: Bundle?)
}