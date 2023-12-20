package com.example.zebratoolkit.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.zebratoolkit.data.IOTDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun IOTConfigSettings(iotDataViewModel: IOTDataViewModel) {

    val managementsCommands: String by iotDataViewModel.mgmtCommands.observeAsState("")
    val serverIP: String by iotDataViewModel.serverUri.observeAsState("")
    var myTexto by rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            OutlinedTextField(
                value = serverIP,
                onValueChange = { iotDataViewModel.onServerUriChanged(it) },
                label = { Text(text = "MQTT Server IP") })

            OutlinedTextField(
                value = managementsCommands,
                onValueChange = { iotDataViewModel.onMgmtCommandsChanged(it) },
                label = { Text(text = "Management Commands") })


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

