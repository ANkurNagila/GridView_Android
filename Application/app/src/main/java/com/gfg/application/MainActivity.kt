package com.gfg.application

import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for grid view and course list
    lateinit var courseGRV: GridView
    lateinit var courseList: List<GridViewModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initializing variables of grid view with their ids.
        courseGRV = findViewById(R.id.idGRV)
        courseList = ArrayList<GridViewModal>()

        // on below line we are adding data to
        // our course list with image and course name.
        courseList = courseList + GridViewModal("C++", R.drawable.cpp)
        courseList = courseList + GridViewModal("Java", R.drawable.java)
        courseList = courseList + GridViewModal("Ruby", R.drawable.ruby)
        courseList = courseList + GridViewModal("Python", R.drawable.py)
        courseList = courseList + GridViewModal("Javascript", R.drawable.js)

        // on below line we are initializing our course adapter
        // and passing course list and context.
        val courseAdapter = GridRVAdapter(courseList = courseList, this@MainActivity)

        // on below line we are setting adapter to our grid view.
        courseGRV.adapter = courseAdapter

        // on below line we are adding on item
        // click listener for our grid view.
        courseGRV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.
            Toast.makeText(
                applicationContext, courseList[position].courseName + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}