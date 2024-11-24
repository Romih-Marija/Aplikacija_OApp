package com.example.aplikacija_oapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

@Composable
fun Menu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)  //
    ,

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
            modifier = Modifier.padding(bottom = 25.dp),
            text = "OSEBNA ASISTENCA",
            fontSize = 23.sp,
            fontWeight = FontWeight(500)
        )

        Column(
            modifier = Modifier

                .background(Color(0xFFBBDEFB)) // Svetlo modra barva
                .padding(top = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomButton(text = "IŠČEM ASISTENCO") {
                // Logika za klik na "IŠČEM ASISTENCO"
            }

            CustomButton(text = "NUDIM ASISTENCO") {
                // Logika za klik na "NUDIM ASISTENCO"
            }

            CustomButton(text = "IŠČEM NADOMEŠČANJE") {
                // Logika za klik na "IŠČEM NADOMEŠČANJE"
            }

            CustomButton(text = "NUDIM NADOMEŠČANJE") {
                // Logika za klik na "NUDIM NADOMEŠČANJE"
            }


            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "OApp - Osebna asistenca - 2024",
                modifier = Modifier.padding(bottom = 20.dp, top = 35.dp)
            )
        }
    }
}
@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
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
            fontSize = 21.sp
        )
    }
}