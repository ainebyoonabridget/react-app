package com.example.hello2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*
import layout.CoursesRecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val Any?.courses: Any
    get() {
        TODO("Not yet implemented")
    }
private var Any.layoutManager: LinearLayoutManager
    get() {
        TODO("Not yet implemented")
    }
    set() {}
private var Any.adapter: Any
    get() {
        TODO("Not yet implemented")
    }
    set() {}
val baseContext: Context?

data class Coursesactivity(val courses_id:Int, val courses_name:String, val course_code:Int, val instructor:String, val Description:String)
class coursesactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coursesactivity)
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        val CoursesAdapter = CoursesRecyclerViewAdapter(
            listOf(
                Coursesactivity(206, "Kotlin", 301, "John", "Android"),
                Coursesactivity(207, "Python", 201, "James", "django project"),
                Coursesactivity(208, "Javascript", 101, "Purity", "React project"),
                Coursesactivity(209, "UI/UX Design", 203, "Nyandia", "Design tools"),
                Coursesactivity(300, "Hardware Design", 403, "Yassin", "Autodesk Fusion"),
                Coursesactivity(401, "Hardware Electronics", 406, "Yassin", "Arduino"),
                Coursesactivity(502, "UI/UX Development", 303, "Jeff", "HTLM/CSS"),
                Coursesactivity(603, "Professional Development", 908, "Rodger", "cover letter"),
                Coursesactivity(704, "Entrepreneurship", 698, "Kellie", "market segmentation"),
                Coursesactivity(805, "Navigating to your journey", 490, "Veronica", " personal values")

            )
        )
        rvCourses.adapter =CoursesAdapter
    }

}
fetchCourses()
}

fun fetchCourses() {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
    val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

    val apiClient = ApiClient.buildService(ApiInterface::class.java)
    val coursesCall = apiClient.getCourses("Bearer " + accessToken)
    coursesCall.enqueue(object : Callback<CoursesResponse> {
        override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }

        fun onResponse(
            call: Call<CoursesResponse>,
            response: Response<Any>,
            rvCourses: Any
        ) {
            if (response.isSuccessful) {
                var courseList = response.body()?.courses as List<Course>
                var coursesAdapter = CoursesAdapter(courseList)
                rvCourses.layoutManager = LinearLayoutManager(baseContext)
                rvCourses.adapter = coursesAdapter
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }

        override fun onResponse(call: Call<CoursesResponse>, response: Response<CoursesResponse>) {
            TODO("Not yet implemented")
        }
    })
}

private fun Any.enqueue(any: Any) {
    TODO("Not yet implemented")
}
}

