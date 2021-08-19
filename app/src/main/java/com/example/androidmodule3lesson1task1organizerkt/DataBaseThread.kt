package com.example.androidmodule3lesson1task1organizerkt

class DataBaseThread:Runnable {

    var db:AppDatabase? = null
    var taskDao: OrganizerTaskDao? = null

    init {
        Thread(this).start()
    }
    override fun run() {
        db=App.instance?.database
        taskDao=db?.organizerTaskDao()
   //  val db=App.instance?.database
    // val taskDao=db?.organizerTaskDao()
      //  val task1 =OrganizerTask(10,"go to shop","buy yogurt")
     //  taskDao?.insert(task1)
    }

    fun getData():List<OrganizerTask> {
        var res:List<OrganizerTask>
        res= emptyList()
        if(taskDao!=null){
           res= taskDao!!.getAll()
        }
        return res
    }

}