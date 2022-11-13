package com.zhasaApp.ui.users.models

import com.zhasaApp.domain.models.Percentage

data class UserModel(
    val fullName: String,
    val branchName: String,
    val kvcPercentage: Percentage
)

typealias UsersList = List<UserModel>
