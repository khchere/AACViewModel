package com.khchere.newproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.khchere.newproject.db.dao.RepoDao
import com.khchere.newproject.model.Repo

@Database(entities = [Repo::class], version = 1, exportSchema = false)
abstract class MyDatabase :RoomDatabase(){
    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "my_database").build()
                }
            }

            return INSTANCE!!
        }

    }

    abstract fun reposDao() : RepoDao
}