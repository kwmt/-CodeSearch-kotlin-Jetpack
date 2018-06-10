package net.kwmt27.codesearch.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.ui.event.EventListViewModel

class ViewModelFactory(private val fetchEventListUseCase: FetchEventListUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventListViewModel(fetchEventListUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}