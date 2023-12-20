package com.example.zebratoolkit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.zebratoolkit.data.IOTDataViewModel
import com.example.zebratoolkit.ui.MqttHandler
import com.example.zebratoolkit.ui.Topics_IOT
import java.io.IOException

@Composable
fun IOTScreen(
    navHostController: NavHostController,
    mqttClient: MqttHandler,
    iotDataViewModel: IOTDataViewModel
) {
    val dataStringTopic: String by iotDataViewModel.data.observeAsState("/apps/ZebraFX_Reader/data")
    //val managementsCommands: String by iotDataViewModel.mgmtCommands.observeAsState("/apps/ZebraFX_Reader/mgmt/commands")
    val managementsCommands: String by iotDataViewModel.mgmtCommands.observeAsState("")
    var localContext = LocalContext.current
    var topicsIOT = Topics_IOT()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MQTT Client")

        Button(onClick = {
            mqttClient.connect(localContext)
        }) {
            Text("Connect")
        }
        Button(onClick = {
            mqttClient.disconnect()
        }) {
            Text("Disconnect")
        }
        Button(onClick = {
            // mqttClient.subscribe("/apps/ZebraFX_Reader/data",2)
            mqttClient.subscribe(dataStringTopic, 2)
        }) {
            Text("Subscribe")
        }

        Button(onClick = {  }) {
            Text("Unsubscribe")
        }


        Button(onClick = {

            var jsonString: String =""
            try {
                jsonString = localContext.assets.open("startRead.json").bufferedReader().use { it.readText() }

            } catch (ioException: IOException) {
                ioException.printStackTrace()

            }
            mqttClient.publish(
                // topic ="/apps/ZebraFX_Reader/mgmt/commands",
                topic = managementsCommands,
                msg = jsonString,
                qos = 0,
                retained = false
            )

        }
        ) {
            Text("Start Read")
        }

        Button(onClick = {

            var jsonString: String =""
            try {
                jsonString = localContext.assets.open("stopRead.json").bufferedReader().use { it.readText() }
                var a =0
            } catch (ioException: IOException) {
                ioException.printStackTrace()

            }
            mqttClient.publish(
                // topic ="/apps/ZebraFX_Reader/mgmt/commands",
                topic = managementsCommands,
                msg = jsonString,
                qos = 0,
                retained = false
            )

        }
        ) {
            Text("Stop Read")
        }

        Button(onClick = {

            var jsonString: String =""
            try {
                jsonString = localContext.assets.open("configA.json").bufferedReader().use { it.readText() }
                var a =0
            } catch (ioException: IOException) {
                ioException.printStackTrace()

            }
            mqttClient.publish(
                // topic ="/apps/ZebraFX_Reader/mgmt/commands",
                topic = managementsCommands,
                msg = jsonString,
                qos = 0,
                retained = false
            )

        }
        ) {
            Text("Send Confg A")
        }

        Button(onClick = {

            var jsonString: String =""
            try {
                jsonString = localContext.assets.open("configB.json").bufferedReader().use { it.readText() }

            } catch (ioException: IOException) {
                ioException.printStackTrace()

            }
            mqttClient.publish(
                //topic ="/apps/ZebraFX_Reader/mgmt/commands",
                topic = managementsCommands,
                msg = jsonString,
                qos = 0,
                retained = false
            )

        }
        ) {
            Text("Send Confg B")
        }

    }





}