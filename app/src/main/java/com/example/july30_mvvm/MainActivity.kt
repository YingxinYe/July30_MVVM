package com.example.july30_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userModel:UserModel ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //we just have to call the view model from our activity and view model is responsible of providing data
        //view model will take care of any orientation changes and will not destroy the data
        //b/c view model have its own life cycle when there is orientation change it will not destroy its instance it will
        //pass the last created instance and keep the last received data alive

        //without view model when the activity is destoryed by android OS or by orientation change. It has to call the data again
        //that result in memory and performance issues to overcome this problem viewmodel provides its own lifecycle
        var mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //it will load the new data in general case. Will provide the old instance of viewmodel

        userModel = mainViewModel.getUserData()
        text_email.setText (userModel?.email)
        text_pw.setText(userModel?.password)

        button.setOnClickListener(View.OnClickListener {
            userModel  = mainViewModel.getNewData()
            text_email.setText (userModel?.email)
            text_pw.setText(userModel?.password)})
    }
}
