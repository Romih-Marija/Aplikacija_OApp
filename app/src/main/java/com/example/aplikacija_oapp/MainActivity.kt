package com.example.aplikacija_oapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume called: Activity is now visible.")
        Toast.makeText(this, "Dobrodošli nazaj!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop called")
        Toast.makeText(this, "Nasvidenje!", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy called")
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
