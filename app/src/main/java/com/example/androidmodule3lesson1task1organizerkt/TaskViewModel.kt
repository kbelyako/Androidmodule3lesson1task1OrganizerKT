package com.example.androidmodule3lesson1task1organizerkt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application):AndroidViewModel(application) {

private val readAllData:List<OrganizerTask>
private val repository:TaskRepository
    init {

        val tasksDao=AppDatabase.getDB(application).organizerTaskDao()
        val dbThread:DataBaseThread=DataBaseThread()
      //  dbThread.taskDao

    //    repository=TaskRepository(tasksDao)
        repository=TaskRepository(dbThread.taskDao!!)
        readAllData=repository.readAllData

    }

    fun addTask(organizerTask: OrganizerTask) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addTask(organizerTask)
        }
    }
}