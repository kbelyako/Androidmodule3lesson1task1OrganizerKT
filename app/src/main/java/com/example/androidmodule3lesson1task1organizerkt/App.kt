package com.example.androidmodule3lesson1task1organizerkt

import android.app.Application
import androidx.room.Room


class App : Application() {
    var database: AppDatabase? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        var instance: App? = null
    }
}
