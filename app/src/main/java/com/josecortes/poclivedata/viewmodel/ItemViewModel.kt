package com.josecortes.poclivedata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.josecortes.poclivedata.repositories.ItemRepository

class ItemViewModel: ViewModel(){

    private val itemRepository = ItemRepository()
    val id = MutableLiveData<Int>()
    val description = MutableLiveData<String>()

    fun init(){
        itemRepository.findItems {
            // Receive this callback when there is new data in the repo and notify LiveData items
            id.postValue(it.id)
            description.postValue(it.description)
        }
    }
}