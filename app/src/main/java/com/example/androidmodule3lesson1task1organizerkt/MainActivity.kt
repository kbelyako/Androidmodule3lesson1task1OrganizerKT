package com.example.androidmodule3lesson1task1organizerkt
/*
ДЗ. Задание 1. Среднее
Написать органайзер. На главном экране список дел (у каждого дела: тема, описание, время, и
возможность сделать важным и оно выделится в списке более другим цветом). Можно
создавать дела, редактировать, удалять.
Дела сохраняются в БД, т.е. не пропадают при новом запуске приложения.
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.android.synthetic.main.activity_main1.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
       // DataBaseThread()
        val dbThread:DataBaseThread=DataBaseThread()
       // val alTasks:LiveData<List<OrganizerTask>>
        val allTasks:List<OrganizerTask>
       // dbThread.run()
       // alTasks = dbThread.taskDao?.getAll()!!
       //allTasks=dbThread.getData()

       // Log.d("mylog","size="+ alTasks.value?.size.toString())
       // Log.d("mylog","sizeTask="+ allTasks.size)


       // Thread {

       // }.start()

        //alTasks.size

        //  Thread {
        //   alTasks=dbThread.taskDao?.getAll()!!

              /*dbThread.taskDao?.clear()
              //Do your database´s operations here

      }
        }


               */


                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fr_FrameLayout, ListFragmentTH.newInstance("ff","ff",dbThread))
                    .commit()








      //  DataBaseThread.taskDao?.insert(task1)

    }
}