package com.example.aplikacija_oapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplikacija_oapp.ui.screens.IscemAsistenco
import com.example.aplikacija_oapp.ui.screens.IscemNadomescanje
import com.example.aplikacija_oapp.ui.screens.Menu
import com.example.aplikacija_oapp.ui.screens.NudimAsistenco
import com.example.aplikacija_oapp.ui.screens.NudimNadomescanje

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") { Menu(navController) }
        composable("iscemAsistenco") { IscemAsistenco() }
        composable("nudimAsistenco") { NudimAsistenco() }
        composable("iscemNadomescanje") { IscemNadomescanje() }
        composable("nudimNadomescanje") { NudimNadomescanje() }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting("Android")

}
