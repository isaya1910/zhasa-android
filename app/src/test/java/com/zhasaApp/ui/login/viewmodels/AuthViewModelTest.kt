package com.zhasaApp.ui.login.viewmodels

import com.zhasaApp.repository.User
import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.repository.result.RequestResult.*
import com.zhasaApp.ui.login.models.LoginAction
import com.zhasaApp.ui.login.models.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@ExperimentalCoroutinesApi
class MainCoroutineRule(private val dispatcher: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
internal class AuthViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val authMiddleware: AuthMiddleWare = AuthMiddleWare(
        object : AuthRepository {
            override suspend fun authenticate(
                email: String,
                password: String
            ): RequestResult<User> {
                if (email == "test" && password == "test") {
                    return Success(User("", "", ""))
                }

                return Error("error")
            }
        }
    )

    private val testObject: AuthViewModel = AuthViewModel(authMiddleware, AuthReducer())

    @Before
    fun setup() {
        testObject.bind()
    }

    @Test
    fun tryAuth() = runTest(UnconfinedTestDispatcher()) {
        val expected = listOf(LoginState.InitialState, LoginState.LoadingState, LoginState.SuccessState)
        val actual = mutableListOf<LoginState>()

        val job = testObject.publicState.onEach {
            actual.add(it)
        }.launchIn(this)

        testObject.obtainAction(LoginAction.Login("test", "test"))

        assertEquals(expected, actual)
        job.cancel()
    }

    @Test
    fun tryAuthFail() = runTest(UnconfinedTestDispatcher()) {
        val expected = listOf(LoginState.InitialState, LoginState.LoadingState, LoginState.ErrorState("error"))
        val actual = mutableListOf<LoginState>()

        val job = testObject.publicState.onEach {
            actual.add(it)
        }.launchIn(this)

        testObject.obtainAction(LoginAction.Login("", ""))

        assertEquals(expected, actual)
        job.cancel()
    }
}
