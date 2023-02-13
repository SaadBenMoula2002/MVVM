package com.example.mvvm.model

class User(var email: String, var password: String) {
    @JvmName("setEmail1")
    fun setEmail(email: String) {
        this.email = email
    }
    @JvmName("getEmail1")
    fun getEmail(): String {
        return email
    }
    @JvmName("setPassword1")
    fun setPassword(password: String) {
        this.password = password
    }
    @JvmName("getPassword1")
    fun getPassword(): String {
        return password
    }
}
