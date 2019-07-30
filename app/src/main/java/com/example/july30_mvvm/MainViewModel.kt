package com.example.july30_mvvm

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var userModel:UserModel ?=null

    fun getUserData():UserModel?{
        if(userModel == null){
            loadData()
        }
        return userModel
    }

    private fun loadData() {
        userModel = UserModel()

        userModel ?.email = "w@gmail.com"
        userModel ?.password = "pw"
    }

    fun getNewData():UserModel?{
        userModel = UserModel()
        userModel ?.email = "new@gmail.com"
        userModel ?.password = "newpw"
        return userModel
    }
}