package com.zhasa.mvi

interface Reducer<A : Action, S : State> {
    fun reduce(action: A, state: S): S
    operator fun invoke(action: A, state: S) = reduce(action, state)
}

