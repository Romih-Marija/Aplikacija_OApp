package com.example.aplikacija_oapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplikacija_oapp.R

@Composable
fun MenuAppHeader(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(130.dp)
                .padding(bottom = 15.dp, top = 35.dp)
        )

        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 25.dp),
            fontSize = 23.sp,
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
            .height(120.dp)
            .padding(10.dp)
            .padding(horizontal = 30.dp)
            .border(2.dp, Color.Gray, shape = RoundedCornerShape(50.dp))
    ) {
        Text(
            text = text,
            fontSize = 19.sp
        )
    }
}
@Composable
fun Footer() {
    Text(
        text = "OApp - Osebna asistenca - 2024",
        modifier = Modifier.padding(bottom = 20.dp, top = 35.dp),
        color = Color.Black
    )
}