package com.zhasa_app.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.zhasa_app.ui.navigation.MainBottomView
import com.zhasa_app.ui.navigation.NavigationGraph
import com.zhasa_app.ui.theme.Colors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colors = Colors.darkColors) {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { MainBottomView(navController) },
                    floatingActionButtonPosition = FabPosition.Center,
                    floatingActionButton = {
                        FloatingActionButton(
                            shape = CircleShape,
                            contentColor = Color.White,
                            onClick = {

                            }) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add icon"
                            )
                        }
                    }) {
                    NavigationGraph(navController = navController)
                    it.calculateBottomPadding()
                }
            }
        }
    }
}
