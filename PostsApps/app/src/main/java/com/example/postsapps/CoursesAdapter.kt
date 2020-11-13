package com.example.hello.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hello.models.Course
import com.example.hello.R
import kotlinx.android.synthetic.main.row_course_item.view.*

class CoursesAdapter(
    var courseList: List<Course>,
    var courseItemClickListener: CourseItemClickListener
) : RecyclerView.Adapter<CoursesAdapter.CoursesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_course_item, parent, false)
        return CoursesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        holder.rowView.tvCourseCode.text = courseList[position].courseCode
        holder.rowView.tvCourseName.text = courseList[position].courseName
        holder.rowView.tvDescription.text = courseList[position].description
        holder.rowView.tvInstructor.text = courseList[position].instructor
        holder.rowView.btnRegisterCourse.setOnClickListener {
            courseItemClickListener.onItemClick(courseList[position])
        }
    }

    class CoursesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}