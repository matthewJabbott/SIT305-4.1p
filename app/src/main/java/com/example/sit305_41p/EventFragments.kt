package com.example.sit305_41p

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

class EventListFragment : Fragment() {

    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val events by viewModel.allEvents.collectAsState(initial = emptyList())


                EventListScreen(
                    events = events,
                    onAddClick = { findNavController().navigate(R.id.addEventFragment) },
                    onDelete = { viewModel.deleteEvent(it) }
                )
            }
        }
    }
}


class AddEventFragment : Fragment() {
    private val viewModel: EventViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AddEventScreen(onSave = { title, cat, loc, time ->
                    if (title.isBlank()) {
                        android.widget.Toast.makeText(requireContext(), "Please enter a title", android.widget.Toast.LENGTH_SHORT).show()
                    } else {
                        viewModel.addEvent(
                            Event(
                                title = title,
                                category = cat,
                                location = loc,
                                date = "",
                                timestamp = time
                            )
                        )
                        findNavController().popBackStack()
                    }
                })
            }
        }
    }
}