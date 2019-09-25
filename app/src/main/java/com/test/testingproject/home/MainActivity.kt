package com.test.testingproject.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.test.testingproject.R
import com.test.testingproject.auth.AuthListener
import com.test.testingproject.auth.AuthViewModel
import com.test.testingproject.databinding.ActivityMainBinding
import com.test.testingproject.util.toast

class MainActivity : AppCompatActivity(),AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        val binding:ActivityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main )
        binding.viewmodel=viewModel
        viewModel.authlistener=this
    }
    override fun onStarts() {
        Log.d("vw","Starts")
        toast("Started")
    }

    override fun onSuccess() {
        toast("Success")
    }

    override fun onFailiure(message: String) {
        toast(message)
    }


}
