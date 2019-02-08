package com.example.design_component

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_club.view.*
import kotlinx.android.synthetic.main.item_header.view.*
import java.util.concurrent.atomic.AtomicBoolean

class RoomAdapter :
    ListAdapter<Any, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<Any?>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            )
            2 -> RoomViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_club, parent, false)
            )
            else -> throw java.lang.IllegalArgumentException("Unknown item type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RoomViewHolder) {
            holder.bindValue(getItem(position) as Room)
        } else if (holder is HeaderViewHolder) {
            holder.bindValue(getItem(position) as Header)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Header -> 1
            is Room -> 2
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    fun submitItemList(list: List<Room>?) {
        val newList = mutableListOf<Any>()
        var prevHeader: Header? = null
        val isFirst = AtomicBoolean(true)
        list?.forEach {
            val header = Header(it.isFavorited, isFirst.getAndSet(false))
            if (header.isFavorited != prevHeader?.isFavorited) {
                newList.add(header)
            }
            newList.add(it)
            prevHeader = header
        }
        super.submitList(newList)
    }

    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindValue(room: Room) {
            with(itemView) {
                club_tv_title.text = room.name
                room_tv_desc.text = room.desc
            }
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindValue(header: Header) {
            with(itemView) {
                room_header_tv_title.setText(
                    if (header.isFavorited) R.string.room_pinned else R.string.room_other
                )
                room_header_btn_edit.visibility = if (header.hasButton) View.VISIBLE else View.GONE
                room_header_btn_edit.setOnClickListener {
                    (context as? Activity)?.startActivity(
                        Intent(context, RoomEditActivity::class.java)
                    )
                }
            }
        }
    }
}
