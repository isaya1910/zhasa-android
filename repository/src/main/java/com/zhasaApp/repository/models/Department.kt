package com.zhasaApp.repository.models

sealed class Department {
    object SMALL: Department()
    object MEDIUM: Department()
    object ALL: Department()
    fun getDepartmentRequest(): String? = when (this) {
        SMALL -> "small"
        MEDIUM -> "medium"
        ALL -> null
    }
}