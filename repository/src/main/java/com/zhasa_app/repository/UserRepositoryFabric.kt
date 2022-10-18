package com.zhasa_app.repository

object UserRepositoryFabric {
    fun getUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }
}