package com.iagomichel.inventory.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.iagomichel.inventory.domain.model.Equipment
import com.iagomichel.inventory.domain.usecase.GetFilteredEquipmentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class EquipmentSearchViewModel @Inject constructor(
    private val getFiltered: GetFilteredEquipmentsUseCase
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    val equipments = _query
        .debounce(300)
        .distinctUntilChanged()
        .flatMapLatest { q -> getFiltered.invoke(q) } // Flow<PagingData<Equipment>>
        .cachedIn(viewModelScope)

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }
}


