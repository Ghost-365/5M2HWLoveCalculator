package com.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLove(firstName:String,secondName:String): MutableLiveData<LoveModel> {
        var liveLoveModel = MutableLiveData<LoveModel>()

        LoveService().api.calculatePercentage(firstName, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveModel.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo","onFailure: ${t.message}",)
            }

        })

        return liveLoveModel
    }
}