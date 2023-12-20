package com.example.zebratoolkit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zebratoolkit.data.IOTDataViewModel
import com.example.zebratoolkit.navigation.Routes.IOT
import com.example.zebratoolkit.navigation.Routes.RESTAPI
import com.example.zebratoolkit.screens.IOTScreen
import com.example.zebratoolkit.screens.RestAPI
import com.example.zebratoolkit.ui.MqttHandler

@Composable
fun NavigationHost(navController : NavHostController){
    var mqttClient = MqttHandler()
    var iotDataViewModel = IOTDataViewModel()
   NavHost(navController = navController, startDestination = RESTAPI.route ){

      composable(IOT.route){
          IOTScreen(
              navHostController = navController,
              mqttClient = mqttClient,
              iotDataViewModel = iotDataViewModel
          )
      }

      composable(RESTAPI.route){
         RestAPI()
      }

   }
}