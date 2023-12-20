package com.example.zebratoolkit.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes(
    val route:String,
    val title: String,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    object IOT : Routes(
        route = "iotScreen",
        title = "IOT",
        unSelectedIcon = Icons.Filled.Home,
        selectedIcon = Icons.Outlined.Home
    )

    object RESTAPI : Routes(
        route = "restScreen",
        title = "Rest API",
        unSelectedIcon = Icons.Filled.Home,
        selectedIcon = Icons.Outlined.Home
    )

    object IOTCONFIGSETTINGS : Routes(
        route = "iotconfigsettings",
        title = "IOT Config Setting",
        unSelectedIcon = Icons.Filled.Home,
        selectedIcon = Icons.Outlined.Home

    )


}