package com.example.livedata_apply_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MyViewModel : ViewModel() {

    private var counter: MutableLiveData<Int>? = null

    fun getCounter(): LiveData<Int>? {
        if (counter == null) {
            counter = MutableLiveData()
            counter!!.value = 0
        }
        return counter
    }

    fun setCounter() {
        if (counter == null) {
            counter = MutableLiveData()
            counter!!.value = 0
        }
        val random = Random.nextInt(0,100)
        counter!!.value = random
    }




}