package com.example.hello2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegister.setOnClickListener {
            val intent = Intent(baseContext, RegistrationActivity::class.java)
            startActivity(intent)
        }
        tvRegister.setOnClickListener {
            var UserName = etUSERNAME.text.toString()
            var Password = etPassword.text.toString()


            var requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", UserName)

                .addFormDataPart("password", Password)
                .build()
            //loginUser(requestBody)
            Toast.makeText(baseContext, Password, Toast.LENGTH_LONG).show()


        }
        fun loginStudents(requestBody: RequestBody) {
            val apiClient = ApiClient.buildService(LoginApiInterface::class.java)
            val loginCall = apiClient.loginStudent(requestBody)
            loginCall.enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG)
                            .show()
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.errorBody().toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            })
        }
    }
}