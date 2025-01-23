package com.hossein.dev.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.hossein.dev.newsapp.domain.manager.LocalUserManager
import com.hossein.dev.newsapp.util.Constants.USER_SETTINGS_KEY
import com.hossein.dev.newsapp.util.Constants.APP_ENTRY_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS_KEY)

class LocalUserManagerImpl(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

}

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = APP_ENTRY_KEY)
}