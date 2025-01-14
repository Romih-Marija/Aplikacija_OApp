package com.example.aplikacija_oapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.aplikacija_oapp.ui.components.BlueColumn
import com.example.aplikacija_oapp.ui.components.MenuAppHeader
import com.example.aplikacija_oapp.ui.components.MenuCustomButton
import com.example.aplikacija_oapp.ui.components.ScreenLayout

@Composable
fun Menu(navController: NavController) {
    ScreenLayout() {
        MenuAppHeader(title = "OSEBNA ASISTENCA")
        BlueColumn() {

            MenuCustomButton(text = "IŠČEM ASISTENCO") {
                navController.navigate("iscemAsistenco")
            }

            MenuCustomButton(text = "NUDIM ASISTENCO") {
                navController.navigate("nudimAsistenco")
            }

            MenuCustomButton(text = "IŠČEM NADOMEŠČANJE") {
                navController.navigate("iscemNadomescanje")
            }

            MenuCustomButton(text = "NUDIM NADOMEŠČANJE") {
                navController.navigate("nudimNadomescanje")
            }
        }
    }
}
