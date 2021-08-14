package com.example.androidmodule3lesson1task1organizerkt

import androidx.lifecycle.LiveData

class TaskRepository(private val organizerTaskDao: OrganizerTaskDao) {

    val readAllData: List<OrganizerTask> = organizerTaskDao.getAll()

    fun addTask(organizerTask: OrganizerTask) {
        organizerTaskDao.insert(organizerTask)
    }

}