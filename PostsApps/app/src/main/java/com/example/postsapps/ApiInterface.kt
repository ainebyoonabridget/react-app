package com.example.hello.api

import android.telecom.Call
import com.example.hello.models.CoursesResponse
import com.example.hello.models.LoginResponse
import com.example.hello.models.RegisterCourse
import com.example.hello.models.RegistrationResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>

    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<LoginResponse>


    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>

    @POST("register-course")
    fun registerCourse(
        @Body requestBody: RequestBody,
        @Header("Authorization") accessToken: String
    ): Call<RegisterCourse>

}