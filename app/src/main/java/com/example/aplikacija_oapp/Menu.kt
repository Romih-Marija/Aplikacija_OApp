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
import androidx.navigation.NavController
import com.example.aplikacija_oapp.components.Footer
import com.example.aplikacija_oapp.components.MenuAppHeader
import com.example.aplikacija_oapp.components.MenuCustomButton

@Composable
fun Menu(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)  //
    ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MenuAppHeader(title = "OSEBNA ASISTENCA")
        Column(
            modifier = Modifier

                .background(Color(0xFFBBDEFB))
                .padding(top = 20.dp)
                .fillMaxSize()
                .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuCustomButton(text = "IŠČEM ASISTENCO") {
                navController.navigate("iscemAsistenco")
            }

            MenuCustomButton(text = "NUDIM ASISTENCO") {
                // Logika za klik na "NUDIM ASISTENCO"
            }

            MenuCustomButton(text = "IŠČEM NADOMEŠČANJE") {
                // Logika za klik na "IŠČEM NADOMEŠČANJE"
            }

            MenuCustomButton(text = "NUDIM NADOMEŠČANJE") {
                // Logika za klik na "NUDIM NADOMEŠČANJE"
            }


            Spacer(modifier = Modifier.weight(1f))
            Footer()
        }
    }
}
