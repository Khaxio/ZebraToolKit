package com.example.zebratoolkit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zebratoolkit.datastore.StoreIOTSettings
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun IOTConfigSettings() {

    //to save data to DataStore
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val dataStore = StoreIOTSettings(context)

    val savedServerIPPort = dataStore.getServerIPPort.collectAsState(initial = "")
    val topicMgmntCmmnds = dataStore.getTopicMgmntCmmnds.collectAsState(initial = "")

    var serverIPPort by rememberSaveable { mutableStateOf("") }
    var topicMngCmd by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp),
                value = serverIPPort,
                singleLine = true,
                onValueChange = {
                    serverIPPort = it

                },
                label = { Text(text = "MQTT Srvr IP:Port") })

            Text(text = savedServerIPPort.value!!)

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp),
                value = topicMngCmd,

                onValueChange = { topicMngCmd = it },
                label = { Text(text = "Management Commands") })
            Text(text = topicMgmntCmmnds.value!!)
            Button(
                modifier = Modifier
                    .padding(40.dp),
                onClick = {
                    //launch the class in a coroutine scope
                    scope.launch {
                        dataStore.saveServerIPPort(serverIPPort)
                        dataStore.saveTopicMgmntCmmnds(topicMngCmd)
                    }
                },
            ) {
                // button text
                Text(
                    text = "Save Settings",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

        }
    }
}

