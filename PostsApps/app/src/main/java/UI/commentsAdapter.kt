package com.example.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Comment
import kotlinx.android.synthetic.main.row_item_comments.view.*

class CommentsAdapter(
    var comments: List<Comment>
) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_comments, parent, false)

    )

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var comment = comments[position]
        holder.itemView.body.text = comment.body
        holder.itemView.email.text = comment.email
        holder.itemView.name.text = comment.name
        holder.itemView.Id.text = comment.id.toString()
        holder.itemView.postId.text = comment.postId.toString()


    }
}