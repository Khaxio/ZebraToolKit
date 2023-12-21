package com.example.zebratoolkit.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class StoreIOTSettings(private val context: Context) {

    //this to make sure there´s only one instance
    companion object {
        //to track IP&Port for MQTT Server
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Server_IP_Port")
        val SERVER_IP_PORT_KEY = stringPreferencesKey("server_ip_port")

        //to track Topic Managements Commands

        private val Context.datastore: DataStore<Preferences> by preferencesDataStore("Topic_Mgmt_Cmmnds")
        val TOPIC_MGMT_CMMNDS = stringPreferencesKey("topic_mgmt_cmmnds")

    }


    //to get the server ip&port
    val getServerIPPort: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SERVER_IP_PORT_KEY]
        }

    //to set the server ip&Port
    suspend fun saveServerIPPort(ipport: String) {
        context.dataStore.edit { preferences ->
            preferences[SERVER_IP_PORT_KEY] = ipport
        }

    }

    //to get the Topic Management Commands
    val getTopicMgmntCmmnds: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[TOPIC_MGMT_CMMNDS]
        }

    //to set Topico Management Commands
    suspend fun saveTopicMgmntCmmnds(topicMgmtCmmnds: String) {
        context.dataStore.edit { preferences ->
            preferences[TOPIC_MGMT_CMMNDS] = topicMgmtCmmnds
        }
    }


}