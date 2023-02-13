package com.example.mvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodels.LoginViewModel
import androidx.databinding.BindingAdapter as DatabindingBindingAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityMainBinding.viewModel = LoginViewModel()
        activityMainBinding.executePendingBindings()
    }
    @DatabindingBindingAdapter("toastMessage")

    fun runMe(view: View, message: String?) {
        if (message != null) {
            Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
