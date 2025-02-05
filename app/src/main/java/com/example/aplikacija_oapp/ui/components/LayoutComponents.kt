package com.example.aplikacija_oapp.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikacija_oapp.R
import com.example.aplikacija_oapp.data.Post
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter

@Composable
fun ScreenLayout(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}
@Composable
fun BlueColumn(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color(0xFFBBDEFB))
            .padding(top = 15.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
        Spacer(modifier = Modifier.weight(1f))
        Footer()
    }
}
@Composable
fun Footer() {
    Text(
        text = "OApp - Osebna asistenca - 2024",
        modifier = Modifier.padding(bottom = 20.dp, top = 25.dp),
        color = Color.Black
    )
}

@Composable
fun AppHeader(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(72.dp)
                .padding(bottom = 7.dp, top = 23.dp)
        )

        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 15.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.Black
        )
    }
}
@Composable
fun MenuAppHeader(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 15.dp, top = 35.dp)
        )

        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 25.dp),
            fontSize = 22.sp,
            fontWeight = FontWeight(500),
            color = Color.Black
        )
    }
}
@Composable
fun MenuCustomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(8.dp)
            .padding(horizontal = 32.dp)
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(50.dp))
    ) {
        Text(
            text = text,
            fontSize = 19.sp
        )
    }
}
@Composable
fun PostForm(onSubmit: (Int, String, String, String, String, String, String?) -> Unit, onCancel: () -> Unit) {
    var id by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri?.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ime") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = surname,
            onValueChange = { surname = it },
            label = { Text("Priimek") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Lokacija") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = contact,
                onValueChange = { contact = it },
                label = { Text("Kontakt") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Opis") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .height(150.dp)
        )
            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Dodaj sliko", fontSize = 15.sp)
            }

            imageUri?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = "Izbrana slika",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

        Row(
            modifier = Modifier
                .padding(15.dp, 5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Button(onClick = { onSubmit(id, name, surname, location, contact, description, imageUri) }
            ) {
                Text( text = "Objavi",
                    fontSize = 18.sp)
            }
            Button(onClick = { onCancel() })
            {
                Text("Prekliči",
                    fontSize = 18.sp)
            }
        }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .padding(20.dp, 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            post.imageUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Slika objave",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )
            }
            Text("${post.name} ${post.surname}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth() .padding(0.dp, 10.dp))
            Text("Lokacija: ${post.location}",
                fontWeight = FontWeight.Bold)
            Text("Kontakt: ${post.contact}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp))
            Text("${post.description}")

        }
    }
}
@Composable
fun Post2Form(onSubmit: (Int, String, String, String, String, String, String?) -> Unit, onCancel: () -> Unit) {
    var id by remember { mutableStateOf(0) }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var contact by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<String?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri?.toString()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(Color.White, RoundedCornerShape(16.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Ime") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = surname,
                onValueChange = { surname = it },
                label = { Text("Priimek") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Lokacija") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = contact,
                onValueChange = { contact = it },
                label = { Text("Kontakt") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Opis") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(150.dp)
            )
            Button(
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "Dodaj sliko", fontSize = 15.sp)
            }

            imageUri?.let {
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = "Izbrana slika",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            Row(
                modifier = Modifier
                    .padding(15.dp, 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Button(onClick = { onSubmit(id, name, surname, location, contact, description, imageUri) }
                ) {
                    Text( text = "Objavi",
                        fontSize = 18.sp)
                }
                Button(onClick = { onCancel() })
                {
                    Text("Prekliči",
                        fontSize = 18.sp)
                }
            }
        }
    }
}

@Composable
fun Post2Item(post: Post) {
    Card(
        modifier = Modifier

            .fillMaxWidth()
            .padding(20.dp, 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            post.imageUri?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "Slika objave",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )
            }
            Text("${post.name} ${post.surname}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth() .padding(0.dp, 10.dp))
            Text("Lokacija: ${post.location}",
                fontWeight = FontWeight.Bold)
            Text("Kontakt: ${post.contact}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp))
            Text("${post.description}")

        }
    }
}