package com.zhasa.mvi

interface MiddleWare<A> {
    suspend fun effect(action: A): A
    suspend operator fun invoke(action: A) = effect(action)
}