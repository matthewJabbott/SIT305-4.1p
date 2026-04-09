package com.example.sit305_41p

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.DatePicker

@Composable
fun EventItem(event: Event, onDelete: () -> Unit) {
    val formatter = remember { SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()) }
    val readableDate = formatter.format(Date(event.timestamp))

    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = event.title, style = MaterialTheme.typography.headlineSmall)
                SuggestionChip(onClick = {}, label = { Text(event.category) })
            }
            Text(text = "Location: ${event.location}", style = MaterialTheme.typography.bodyMedium)

            Text(text = "Date: $readableDate", style = MaterialTheme.typography.bodySmall)

            Button(onClick = onDelete, modifier = Modifier.padding(top = 8.dp)) {
                Text("Delete")
            }
        }
    }
}

@Composable
fun EventListScreen(events: List<Event>, onAddClick: () -> Unit, onDelete: (Event) -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(events) { event ->
                EventItem(event = event, onDelete = { onDelete(event) })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEventScreen(onSave: (String, String, String, Long) -> Unit) {
    var title by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("Work") }
    var showDatePicker by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            // Subtask 4: Logic Validation (No past dates)
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= System.currentTimeMillis() - 86400000
            }
        }
    )

    Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Event Title") }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))

        Text("Category:", style = MaterialTheme.typography.labelLarge)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Work", "Social", "Travel").forEach { cat ->
                FilterChip(
                    selected = category == cat,
                    onClick = { category = cat },
                    label = { Text(cat) }
                )
            }
        }

        OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showDatePicker = true }, modifier = Modifier.fillMaxWidth()) {
            Text(if (datePickerState.selectedDateMillis == null) "Select Date" else "Date Picked")
        }

        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = { TextButton(onClick = { showDatePicker = false }) { Text("OK") } }
            ) { DatePicker(state = datePickerState) }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (title.isNotBlank() && datePickerState.selectedDateMillis != null) {
                    onSave(title, category, location, datePickerState.selectedDateMillis!!)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Save Event") }
    }
}