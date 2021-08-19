package com.example.androidmodule3lesson1task1organizerkt

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list_th.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragmentTH.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragmentTH : Fragment(), TaskItemCallback {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var dbThread: DataBaseThread


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_th, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var alTasks:List<OrganizerTask>
        val task2=OrganizerTask(0,"go to shop","buy yogurt")


            //  Thread {
         //   alTasks=dbThread.taskDao?.getAll()!!
      //  }.start()



       // if (context!=null){
            //  rvPatients.adapter=PatientAdapter(patients, context!!,this)
          //  rvTasks.adapter=TasksAdapter(alTasks, requireContext(),this)

          //  rvTasks.layoutManager= LinearLayoutManager(context)
            //  ivAvatar.setImageBitmap(ava)
     //   }

        bt_addListTH.setOnClickListener {
            if (activity != null){
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fr_FrameLayout, AddFragmentTH.newInstance("ff", "ff", dbThread))
                    .addToBackStack(null)
                    .commit()
            }
        }
/*
        bt_clearAll.setOnClickListener {
            if (activity != null){
        //  if  (dbThread.taskDao!=null){
        //      dbThread.taskDao?.clear()
        //  }
            Log.d("mylog","DbCleared")
        }
        }

 */

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListtFragmentTH.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String,inDbThread:DataBaseThread) =
            ListFragmentTH().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
                dbThread=inDbThread
            }
    }

   override fun onTaskItemSelected (index: Int){
       Log.d("MyLog","item "+index+" was selected")
   }
}