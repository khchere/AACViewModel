package com.khchere.newproject.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.khchere.newproject.data.MyRepository
import com.khchere.newproject.model.UserData

class UserProfileViewModel : ViewModel() {
    lateinit var user : LiveData<UserData>
    private val userRepo: MyRepository? = MyRepository(application)

    fun init(authCode: String) {
        println("UserProfileViewModel init")
        user = userRepo?.getUser(authCode)!!
    }


}