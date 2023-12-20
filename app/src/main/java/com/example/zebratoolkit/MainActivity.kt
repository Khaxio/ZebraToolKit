package com.example.zebratoolkit


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.zebratoolkit.data.IOTDataViewModel
import com.example.zebratoolkit.screens.IOTConfigSettings
import com.example.zebratoolkit.ui.theme.ZebraToolKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZebraToolKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyMainScreen()
                    IOTConfigSettings(iotDataViewModel = IOTDataViewModel())
                }
            }
        }
    }
}
