package com.example.userlist.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userlist.R
import com.example.userlist.data.remote.model.UserRemote
import com.example.userlist.ui.ImageLoader
import javax.inject.Inject


class UserListAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    var userList: MutableList<UserRemote> = mutableListOf()

    fun addData(users: List<UserRemote>) {
        userList.addAll(users)
        notifyDataSetChanged()
    }

    fun clearData() {
        userList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.user_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        val userRemote: UserRemote = userList[pos]
        viewHolder.userName.text = userRemote.first_name
        viewHolder.userEmail.text = userRemote.email
        imageLoader.loadImage(userRemote.avatar, viewHolder.userImg)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val userImg: ImageView
        val userName: TextView
        val userEmail: TextView


        init {
            userName = itemView.findViewById(R.id.user_name)
            userEmail = itemView.findViewById(R.id.email)
            userImg = itemView.findViewById(R.id.item_profile_img) as ImageView
        }
    }

    override fun getItemCount() = userList.size
}