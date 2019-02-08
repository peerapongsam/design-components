package com.example.design_component

interface ItemTouchHelperAdapter {
    fun onItemMove(formPosition: Int, toPosition: Int): Boolean

    fun onItemDismiss(position: Int)
}
