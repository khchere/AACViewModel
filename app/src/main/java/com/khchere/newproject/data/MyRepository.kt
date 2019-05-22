package com.khchere.newproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.khchere.newproject.api.Webservice
import com.khchere.newproject.model.UserData
import retrofit2.Call
import retrofit2.Callback
import android.content.Context
import android.util.Log
import com.khchere.newproject.db.MyDatabase
import com.khchere.newproject.db.dao.RepoDao
import com.khchere.newproject.model.RepoSearchResponse
import retrofit2.Response
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import android.os.AsyncTask.execute
import com.khchere.newproject.model.Repo


class MyRepository(context: Context) {
    var webservice : Webservice = Webservice.create()
    private val repoDao: RepoDao = MyDatabase.getInstance(context).reposDao()
    private val executor: Executor = Executors.newFixedThreadPool(4)


    fun getUser(authCode:String) : LiveData<UserData>{
        val data : MutableLiveData<UserData> = MutableLiveData()
        Log.d("MyRepository","MyRepository getUser")
        webservice.getUser(authCode).enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                Log.d("MyRepository","MyRepository onResponse")
                data.value = response.body()
            }
            override fun onFailure(call: Call<UserData>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d("MyRepository","getUser : onFailure ${t.message}")
            }
        })

        return data
    }

    fun getRepositData(query:String): LiveData<List<Repo>>{
//        val data : MutableLiveData<RepoSearchResponse> = MutableLiveData()
        /*webservice.searchRepos(query, 1, 50).enqueue(object : Callback<RepoSearchResponse> {
            override fun onResponse(call: Call<RepoSearchResponse>, response: Response<RepoSearchResponse>) {
                Log.d("MyRepository","getRepositData onResponse")
                data.value = response.body()
            }

            override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d("MyRepository","getRepositData : onFailure ${t.message}")
            }
        })*/
        refreshRepoData(query)

        return repoDao.queryRepoData(query)
    }

    fun refreshRepoData(query: String) {
        executor.execute{
            // Refreshes the data.
            val response = webservice.searchRepos(query, 1, 50).execute()
            // Check for errors here.

            // Updates the database. The LiveData object automatically
            // refreshes, so we don't need to do anything else here.
            repoDao.insert()
        }
    }



}