package com.zhasa_app.repository


sealed interface UserRepository {
    suspend fun getUser(token: String): User
}

internal class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUser(token: String): User {
        return userDataSource.syncUser(token)
    }
}

object UserRepo: UserRepository {
    override suspend fun getUser(token: String): User {
        TODO("Not yet implemented")
    }
}

object UserRepositoryImpl2 : UserRepository {
    override suspend fun getUser(token: String): User {
        TODO("Not yet implemented")
    }
}