package com.example.androidmodule3lesson1task1organizerkt

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add_th.*
import kotlinx.android.synthetic.main.fragment_add_th.bt_add_buttonTH
import kotlinx.android.synthetic.main.fragment_add_th.et_TaskDescTH
import kotlinx.android.synthetic.main.fragment_add_th.et_TaskTimeTH
import kotlinx.android.synthetic.main.fragment_add_th.et_TaskTitleTH

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [test.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragmentTH : Fragment() {
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
        return inflater.inflate(R.layout.fragment_add_th, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        bt_add_buttonTH.setOnClickListener {
         /*   val task2=OrganizerTask(0,"Yeeee","buy yogurt")

            Thread {
                dbThread.taskDao?.insert(task2)
            }.start()

          */
            insertDataToDB()

        }
    }

    private fun insertDataToDB() {
        val title=et_TaskTitleTH.text.toString()
        val description=et_TaskDescTH.text.toString()
        val time=et_TaskTimeTH.text.toString()

        val task2=OrganizerTask(0,"go to shop","buy yogurt")

        if(inputCheck(title,description,time)){
            val task=OrganizerTask(0,title,description)
            //mTaskViewModel.addTask(task)

            Thread {
                dbThread.taskDao?.insert(task)
            }.start()
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG)
        }
    }

    private fun inputCheck(title: String, description: String, time: String): Boolean {
        return !(TextUtils.isEmpty(time)&& TextUtils.isEmpty(description)&&time.isEmpty())

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment test.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, inDbThread:DataBaseThread) =
            AddFragmentTH().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
                dbThread=inDbThread
            }
    }
}