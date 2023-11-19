package com.example.trainingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trainingapp.ui.theme.TrainingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TwoButtons()
                }
            }
        }
    }
}


@Composable
fun TwoButtons() {
    Box(
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { /* Действие для кнопки по центру */ },
            modifier = Modifier.padding(8.dp)

        ) {
            Text("Регистрация")
        }
    }
    Box(
        contentAlignment = Alignment.BottomEnd
    ){
        Button(
            onClick = { /* Действие для кнопки по центру */ },
            modifier = Modifier.padding(8.dp)

        ) {
            Text("Пропустить")
        }
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TrainingAppTheme {
        TwoButtons()
    }
}