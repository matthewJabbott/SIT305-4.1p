package com.example.sit305_41p

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = EventDatabase.getDatabase(application).eventDao()
    val allEvents: Flow<List<Event>> = dao.getAllEvents()

    fun addEvent(event: Event) {
        viewModelScope.launch {
            dao.insert(event)
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            dao.delete(event)
        }
    }
}