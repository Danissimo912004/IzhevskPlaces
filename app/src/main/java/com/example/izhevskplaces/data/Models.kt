package com.example.izhevskplaces.data


data class Category(
    val name: String,
    val icon: String,
    val key: String
)

data class Place(
    val id: Int,
    val name: String,
    val category: String,
    val rating: Float,
    val workingHours: String,
    val address: String,
    val description: String,
    val imageResName: String = ""
)