package com.zhasaApp.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhasa.mvi.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : State, A : Action>(private val dispatcherProvider: DispatcherProvider) :
    ViewModel() {
    abstract val stateFlow: MutableStateFlow<S>
    protected abstract val actionFlow: MutableSharedFlow<A>
    protected abstract val middleWares: List<MiddleWare<A>>
    protected abstract val reducer: Reducer<A, S>
    protected abstract val actionFilter: (action: A) -> Boolean

    fun obtainAction(action: A) {
        viewModelScope.launch(dispatcherProvider.io) {
            actionFlow.emit(action)
        }
    }

    fun bind() {
        viewModelScope.launch(dispatcherProvider.io) {
            actionFlow.filter { actionFilter(it) }.collect { a ->
                val reduced = reducer.reduce(a, stateFlow.value)
                stateFlow.value = reduced
                println(reduced::class.java)
                middleWares.forEach { mw ->
                    launch {
                        val effect = mw(a)
                        actionFlow.emit(effect)
                    }
                }
            }
        }
    }
}
