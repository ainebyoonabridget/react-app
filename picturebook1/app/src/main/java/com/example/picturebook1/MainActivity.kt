package com.example.picturebook1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_activity2camel.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNext.setOnClickListener {
            startActivity(Intent(baseContext,MainActivityelephant::class.java))
        }
        btnNext.setOnClickListener {
            startActivity(Intent(baseContext,MainActivitytiger::class.java))
    }
        btnNext.setOnClickListener {
            startActivity(Intent(baseContext,MainActivityflamingo1::class.java))

}
        btnNext.setOnClickListener {
            startActivity(Intent(baseContext, MainActivitylion::class.java))
        }
        btnNext.setOnClickListener {
            startActivity(Intent(baseContext, MainActivityzebra::class.java))
        }


