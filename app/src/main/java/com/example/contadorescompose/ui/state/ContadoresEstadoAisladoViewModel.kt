package com.example.contadorescompose.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadoresEstadoAisladoViewModel: ViewModel() {
    private val _state = MutableStateFlow(ContadoresEstadoAisladoState())
    val state: StateFlow<ContadoresEstadoAisladoState> = _state.asStateFlow()

    fun changeIncrementA(newIncrement: String) {
       _state.value = _state.value.copy(incrementA = newIncrement)
    }

    fun incrementCountA() {
        _state.value = _state.value.copy(countA = _state.value.countA + _state.value.incrementA.toInt())
    }

    fun resetCountA() {
        _state.value = _state.value.copy(countA = 0)
    }

    fun changeIncrementB(newIncrement: String) {
        _state.value = _state.value.copy(incrementB = newIncrement)
    }

    fun incrementCountB() {
        _state.value = _state.value.copy(countB = _state.value.countB + _state.value.incrementB.toInt())
    }

    fun resetCountB() {
        _state.value = _state.value.copy(countB = 0)
    }

    fun incrementCountFinal(newIncrement: Int) {
        _state.value = _state.value.copy(countFinal = _state.value.countFinal + newIncrement)
    }

    fun resetCountFinal() {
        _state.value = _state.value.copy(countFinal = 0)
    }
}