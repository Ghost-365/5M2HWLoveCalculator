package com.example.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel {

    private val repository = Repository()

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }
}