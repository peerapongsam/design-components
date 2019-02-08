package com.example.design_component

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemTouchHelperCallback(val listener: ItemTouchHelperAdapter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: ViewHolder): Int {
        return if ((viewHolder as? DraggableViewHolder)?.isDraggable == true) {
            val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
            ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
        } else {
            0
        }
    }

    override fun onMove(
        recyclerView: RecyclerView,
        source: ViewHolder,
        target: ViewHolder
    ): Boolean {
        if (source.itemViewType != target.itemViewType) {
            return false
        }
        return if ((source as? DraggableViewHolder)?.isDraggable == true && (target as? DraggableViewHolder)?.isDraggable == true) {
            listener.onItemMove(source.adapterPosition, target.adapterPosition)
        } else {
//            Toast.makeText(recyclerView.context, "Move only favorited group", Toast.LENGTH_SHORT)
//                .show()
            false
        }
    }

    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
        listener.onItemDismiss(viewHolder.adapterPosition)
    }
}
