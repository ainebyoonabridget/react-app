package com.example.postsapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Post
import kotlinx.android.synthetic.main.row_item_posts.view.*

class PostsAdapter(
    var posts: List<Post>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_posts, parent, false)
    )

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = posts[position]

        holder.itemView.userId.text = post.userId.toString()
        holder.itemView.ids.text = post.id.toString()
        holder.itemView.title.text = post.title
        holder.itemView.body.text = post.body
        holder.itemView.btnpost.setOnClickListener {



        }

    }

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}