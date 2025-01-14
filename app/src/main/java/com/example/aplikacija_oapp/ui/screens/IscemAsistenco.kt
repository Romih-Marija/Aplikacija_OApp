package com.example.aplikacija_oapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aplikacija_oapp.data.Post
import com.example.aplikacija_oapp.ui.components.AppHeader
import com.example.aplikacija_oapp.ui.components.BlueColumn
import com.example.aplikacija_oapp.ui.components.PostForm
import com.example.aplikacija_oapp.ui.components.PostItem
import com.example.aplikacija_oapp.ui.components.ScreenLayout
import com.example.aplikacija_oapp.ui.viewModels.PostViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun IscemAsistenco() {
    val postViewModel: PostViewModel = viewModel()
    val posts by postViewModel.posts.collectAsState()
    var isFormVisible by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val filteredPosts = posts.filter { post ->
        post.description.contains(searchQuery, ignoreCase = true) || // Filtriraj po opisu
                post.location.contains(searchQuery, ignoreCase = true) ||
                post.contact.contains(searchQuery, ignoreCase = true) ||
                post.name.contains(searchQuery, ignoreCase = true) || // Filtriraj po imenu
                post.surname.contains(searchQuery, ignoreCase = true) // Filtriraj po priimku
    }

    ScreenLayout() {
        AppHeader(title = "IŠČEM ASISTENCO")

        BlueColumn() {
            Button(onClick = { isFormVisible = true }) {
                Text("Dodaj objavo",
                    fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Iskanje - vpiši ključno besedo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 35.dp)
                    .background(Color.White),

            )
            Spacer(modifier = Modifier.padding(8.dp))

            if (isFormVisible) {
                PostForm(
                    onSubmit = { id, name, surname, location, contact, description, imageUri ->
                        postViewModel.addPost(Post(id, name, surname, location, contact, description, imageUri))
                        isFormVisible = false
                    },
                    onCancel = { isFormVisible = false }
                )
            }

            filteredPosts.reversed().forEach { post ->
                PostItem(post)
            }

        }
    }
}
