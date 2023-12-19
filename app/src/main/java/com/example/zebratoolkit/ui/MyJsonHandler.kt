package com.example.zebratoolkit.ui

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MyJsonHandler:AppCompatActivity() {

    val jsonFileString = getJsonDataFromAsset(applicationContext,"startRead.json")
    var jsonFileStringToPass : String = jsonFileString.toString()
   }


//Esta funcion devuelve un string largo el contenido del archivo
fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

