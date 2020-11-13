package com.example.postsapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Posts")
data class Post (
    var userId:Int,
    @PrimaryKey @NonNull var id:Int,
    var title:String,
    var body:String
)