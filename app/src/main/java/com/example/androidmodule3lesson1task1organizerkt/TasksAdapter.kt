package com.example.androidmodule3lesson1task1organizerkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

//import kotlinx.android.synthetic.main.item_news.view.*

class TasksAdapter( val tasksList:List<OrganizerTask>,val context:Context, val callback: TaskItemCallback):RecyclerView.Adapter <ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      //  holder.imgNewsPicture.setImageBitmap(tasksList[position].picture)

        holder.tvTaskTitle.text=tasksList[position].title
        holder.tvTaskDescription.text=tasksList[position].description
        holder.root.setOnClickListener{ callback.onTaskItemSelected(position)}

        holder.like.setOnClickListener{
            holder.tvLikesNum.text=(holder.tvLikesNum.text.toString().toInt()+1).toString()

        }
        holder.disLike.setOnClickListener{

            if(holder.tvLikesNum.text.toString().toInt()>=1) {
                holder.tvLikesNum.text = (holder.tvLikesNum.text.toString().toInt() - 1).toString()
            }

        }

    }

    override fun getItemCount(): Int {
        return tasksList.size
    }


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   // val imgNewsPicture = itemView.ivNewsPicture
    val tvTaskTitle = itemView.tvTaskTitle
    val tvTaskDescription = itemView.tvTaskDescription
    val root=itemView.clTaskItemRootView
    val like=itemView.ivLike
    val disLike=itemView.ivDislike
    //var tvLikesNum=itemView.tvLikesNumber
    var tvLikesNum=itemView.tvLikesNumber
    var likesNumber:Int=0
}

interface TaskItemCallback{
    fun onTaskItemSelected(index:Int)
}