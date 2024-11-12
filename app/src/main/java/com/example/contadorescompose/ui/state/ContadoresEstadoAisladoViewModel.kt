package com.example.contadorescompose.ui.state

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel

class ContadoresEstadoAisladoViewModel: ViewModel() {
    private val _state = ContadoresEstadoAisladoState()
    val state: ContadoresEstadoAisladoState
        get() = _state


    fun incrementCountFinal(increment: Int) {
        _state.countFinal += increment
    }

    fun resetCountFinal() {
        _state.countFinal = 0
    }

    fun incrementCount(increment: Int) {

    }

    fun resetCount() {

    }

    fun modifyIncrementA(increment: String) {
        _state.incrementA = increment
    }
}