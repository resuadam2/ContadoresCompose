package com.example.contadorescompose.ui.state

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class ContadoresEstadoAisladoViewModel: ViewModel() {
    private val _state = ContadoresEstadoAisladoState()
    val state: ContadoresEstadoAisladoState
        get() = _state


    fun incrementCount(increment: Int) {
        _state.count += increment
    }

    fun resetCount() {
        _state.count = 0
    }


    fun modifyIncrement(increment: String) {
        _state.increment = increment
    }
}