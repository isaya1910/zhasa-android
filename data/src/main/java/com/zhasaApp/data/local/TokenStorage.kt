package com.zhasaApp.data.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

interface TokenStorage {
    suspend fun provideToken(): String
    suspend fun saveToken(token: String)
}

internal class PreferencesTokenStorage(private val context: Context) : TokenStorage {
    private val tokenKey = stringPreferencesKey("token")
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
    override suspend fun provideToken(): String {
        Log.d("TOKEN", "PROVIDE")
        return context.dataStore.data.map {
            it[tokenKey]
        }.firstOrNull().orEmpty()
    }

    override suspend fun saveToken(token: String) {
        Log.d("TOKEN", "SAVE")
        context.dataStore.edit {
            it[tokenKey] = token
        }
    }
}