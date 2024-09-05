package com.example.swap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swap.detail.DetailScreen
import com.example.swap.Home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Superficie de la app
            Surface(modifier =
            Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val navController = rememberNavController()
                //Control de navegación
                NavHost(navController =navController , startDestination = "home"){
                    //Primera pantalla
                    composable(route = "home"){
                        HomeScreen{
                            navController.navigate("detail")
                        }
                    }
                    //Segunda pantalla
                    composable(route = "detail"){
                        DetailScreen{
                            navController.navigate("home")
                        }
                    }
                }
            }
        }
    }
}