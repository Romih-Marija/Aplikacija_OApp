package com.example.aplikacija_oapp.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.aplikacija_oapp.data.Post
import com.example.aplikacija_oapp.data.generateSeedPosts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PostViewModel: ViewModel() {
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> get() = _posts
    init {
        _posts.value = generateSeedPosts()
    }
    fun addPost(entities: Post) {
        _posts.value = _posts.value + entities
    }
}