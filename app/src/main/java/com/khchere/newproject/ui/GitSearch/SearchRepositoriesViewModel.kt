package com.khchere.newproject.ui.GitSearch

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.khchere.newproject.data.MyRepository
import com.khchere.newproject.model.RepoSearchResponse

class SearchRepositoriesViewModel(application: Application)  : AndroidViewModel(application) {
    lateinit var user : LiveData<RepoSearchResponse>
    private val userRepo: MyRepository? = MyRepository(application)

    fun searchRepo(query: String) {
        println("SearchRepositoriesViewModel searchRepo")
        user = userRepo?.getRepositData(query)!!
    }

}