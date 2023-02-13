package com.example.mvvm.viewmodels

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvvm.BR
import com.example.mvvm.model.User


class LoginViewModel : BaseObservable() {


    private var user: User = User("","")
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"
    private var toastMessage: String? = null

    @get:Bindable
    val getToastMessage: String?
        get() = this.toastMessage

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.getToastMessage)
    }
    @get:Bindable
    val getUserEmail: String
        get() = user.email

    fun setUserEmail(email: String) {
        user.email = email
        notifyPropertyChanged(BR.getUserEmail)
    }
    @get:Bindable
    val getUserPassword: String
        get() = user.password

    fun setUserPassword(password: String) {
        user.password = password
        notifyPropertyChanged(BR.getUserPassword)
    }

    fun onButtonClicked() {
        if (isValid()) {
            setToastMessage(successMessage)
        } else {
            setToastMessage(errorMessage)
        }
    }
    private fun isValid(): Boolean {
        return !TextUtils.isEmpty(getUserEmail) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserEmail).matches() &&
                getUserPassword.length > 5
    }

}
