package com.example.lab5.dao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lab5.dao.entity.User
import com.example.lab5.dao.interfaces.UserDao

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var userDatabase: UserDatabase? = null

        fun getInstance(context: Context): UserDatabase {
            if (userDatabase == null) {
                userDatabase = Room
                    .databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java, "userDatabase"
                    )
                    .allowMainThreadQueries()
                    .build()
            }
            return userDatabase!!
        }

    }
}