package com.example.aplikacija_oapp.ui.screens


import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.sp


@Composable
fun IscemAsistenco() {
    val postViewModel: PostViewModel = viewModel()
    val posts by postViewModel.posts.collectAsState()
    var isFormVisible by remember { mutableStateOf(false) }

    ScreenLayout() {
        AppHeader(title = "IŠČEM ASISTENCO")

        BlueColumn() {
            Button(onClick = { isFormVisible = true }) {
                Text("Dodaj objavo",
                    fontSize = 18.sp)
            }

            if (isFormVisible) {
                PostForm(
                    onSubmit = { name, surname, description ->
                        postViewModel.addPost(Post(name, surname, description))
                        isFormVisible = false
                    },
                    onCancel = { isFormVisible = false }
                )
            }

            posts.forEach { post ->
                PostItem(post)
            }

        }
    }
}
