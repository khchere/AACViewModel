package com.khchere.newproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.khchere.newproject.model.Repo

@Dao
interface RepoDao :BaseDao<Repo> {

    @Query("SELECT * FROM repos WHERE (name LIKE :queryString) OR (description LIKE " +
            ":queryString) ORDER BY stars DESC, name ASC")
    fun queryRepoData(queryString: String) : LiveData<List<Repo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<Repo>)
}