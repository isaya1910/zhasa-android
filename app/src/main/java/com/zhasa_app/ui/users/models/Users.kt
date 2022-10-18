package com.zhasa_app.ui.users.models

import com.zhasa_app.ui.models.Percentage

data class UserModel(
    val fullName: String,
    val branchName: String,
    val kvcPercentage: Percentage
)

typealias UsersList = List<UserModel>

