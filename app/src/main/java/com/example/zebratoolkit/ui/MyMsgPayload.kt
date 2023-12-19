package com.example.zebratoolkit.ui

data class MyMsgPayload(
    val myCommand:String,
    val myCommand_id:String,
    val myPayload:List<String>
) {
}