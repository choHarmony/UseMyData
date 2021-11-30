package com.hanium.ictapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.community_list_item.view.*

class CommunityListViewAdapter(private val items: ArrayList<CommunityListViewItem>) :
    RecyclerView.Adapter<CommunityListViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CommunityListViewAdapter.ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener {it ->
            //Toast.makeText(it.context,"Clicked", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CommunityListViewAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.community_list_item, parent, false)
        return CommunityListViewAdapter.ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v
        fun bind(listener:View.OnClickListener, item: CommunityListViewItem) {
            view.community_photo.setImageDrawable(item.photo)
            view.community_title.text = item.title
            view.community_content.text = item.content
            view.setOnClickListener(listener)
        }
    }

}