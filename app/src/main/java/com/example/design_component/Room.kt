package com.example.design_component

data class Header(val isFavorited: Boolean, val hasButton: Boolean = false)

data class Room(
    val name: String,
    val desc: String,
    var isFavorited: Boolean = false
)
