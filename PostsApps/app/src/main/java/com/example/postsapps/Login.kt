package com.example.hello.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.hello.models.LoginResponse
import com.example.hello.R
import com.example.hello.api.ApiClient
import com.example.hello.api.ApiInterface
import kotlinx.android.synthetic.main.activity_login.*

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", email)
                .addFormDataPart("password", password)
                .build()

            signInUser(requestBody)

        }
    }

    private fun signInUser(requestBody: RequestBody) {

        var apiClient = ApiClient.buildService(ApiInterface::class.java)
        var call = apiClient.loginStudent(requestBody)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()

                    var accessToken = response.body()?.accessToken
                    val studentId = response.body()?.studentId
                    var sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(baseContext)
                    var editor = sharedPreferences.edit()
                    editor.putString("ACCESS_TOKEN_KEY", accessToken)
                    editor.putString("STUDENT_ID_KEY", studentId)
                    editor.apply()

                    startActivity(Intent(baseContext, CoursesActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.message().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }

        })

    }
}