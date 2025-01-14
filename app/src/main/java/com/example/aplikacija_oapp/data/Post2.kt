package com.example.aplikacija_oapp.data

data class Post2(
    val id: Int,
    val name: String,
    val surname: String,
    var location: String,
    var contact: String,
    val description: String,
    val imageUri: String? = null
)
