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
import androidx.compose.runtime.livedata.observeAsState
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
import com.example.zebratoolkit.data.IOTDataViewModel
import com.example.zebratoolkit.datastore.StoreIOTSettings
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun IOTConfigSettings(iotDataViewModel: IOTDataViewModel) {

    //to save data to DataStore
    val context = LocalContext.current
    val dataStore = StoreIOTSettings(context)

    val savedServerIPPort = dataStore.getServerIPPort.collectAsState(initial = " ")
    val topicMgmntCmmnds = dataStore.getTopicMgmntCmmnds.collectAsState(initial = " ")


    val scope = rememberCoroutineScope()

    val managementsCommands: String by iotDataViewModel.mgmtCommands.observeAsState(" ")
    val serverIP: String by iotDataViewModel.serverUri.observeAsState(" ")
    var myTexto by rememberSaveable { mutableStateOf(" ") }



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
                value = serverIP,
                singleLine = true,
                onValueChange = {
                    iotDataViewModel.onServerUriChanged(it)

                },
                label = { Text(text = "MQTT Srvr IP:Port") })

            Text(text = savedServerIPPort.value!!)

            OutlinedTextField(
                modifier = Modifier
                    .padding(10.dp),
                // value = managementsCommands,
                value = topicMgmntCmmnds.value,
                onValueChange = { iotDataViewModel.onMgmtCommandsChanged(it) },
                label = { Text(text = "Management Commands") })
            Text(text = "texto fijado commands")
            Button(
                modifier = Modifier
                    .padding(40.dp),
                onClick = {
                    //launch the class in a coroutine scope
                    scope.launch {
                        dataStore.saveServerIPPort(serverIP)
                        // dataStore.saveTopicMgmntCmmnds(topicMgmntCmmnds.value!!)
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


            /*OutlinedTextField(
                value = myTexto,
                onValueChange = { myTexto = it },
                label = { Text(text = "Management Events") })
            OutlinedTextField(
                value = "d",
                onValueChange = {  },
                label = { Text(text = "Tag Data Events") })

            OutlinedTextField(
                value = managementsCommands,
                onValueChange = {},
                label = { Text(text = "Management Response") })
            OutlinedTextField(
                value = "xxxxxx",
                onValueChange = {},
                label = { Text(text = "Control Command") })
            OutlinedTextField(
                value = "xxxxxx",
                onValueChange = {},
                label = { Text(text = "Control Response") })*/
        }
    }
}

