package com.example.zebratoolkit.ui

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit

import com.example.zebratoolkit.data.TagBodyClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

@Composable

fun MainReadDataUI(context:Context){
    Box(modifier = Modifier.fillMaxSize()){
        var myTagReaded=""
        myTagReaded= readJsonFile(context)


        Text(text=getMyJsonObject(context))

    }


}
//esto vale para leer unjson y pasarlo a string
fun readJsonFile(context:Context):String {
    var jsonString = ""
    context
    try{
        jsonString = context.assets.open("tagdataExample.json").bufferedReader().use{it.readText()}
    } catch (ioException:IOException){
        ioException.printStackTrace()
    }
    return jsonString
}

//con esto tenemos el objecto json
fun getMyJsonObject(context:Context):String{
    var datoidHex = ""
    val jsonFileString = getJsonDataFromAsset(context,"tagdataExample.json")
    val gson = Gson()
    val objetoType = object:TypeToken<TagBodyClass>(){}.type
    var dataJson:TagBodyClass = gson.fromJson(jsonFileString,objetoType)
    return dataJson.type



}
