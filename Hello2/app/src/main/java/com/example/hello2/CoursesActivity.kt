package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hello2.Course
import kotlinx.android.synthetic.main.activity_courses.*


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        var courseList = listOf(
            Course("5", "Javascript", "Java 101", "Purity Maina", "Web Development"),
            Course("6", "Android Kotlin", "Android 201", "John Owor", "Android development training"),
            Course(
                "7",
                "Python",
                "Django 300",
                "James Mwai",
                "Django project"
            ),
            Course("8", "Design", "Design 100", "Jeff Muthondu", "Web design")
        )

        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesAdapter(courseList)
    }
}