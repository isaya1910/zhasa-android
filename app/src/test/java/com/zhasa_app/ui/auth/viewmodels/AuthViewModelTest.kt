package com.zhasa_app.ui.auth.viewmodels

import com.zhasa_app.repository.User
import com.zhasa_app.repository.auth.AuthRepository
import com.zhasa_app.repository.result.RequestResult
import com.zhasa_app.repository.result.RequestResult.*
import com.zhasa_app.ui.auth.models.AuthAction
import com.zhasa_app.ui.auth.models.AuthState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
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
                return if (email == "test" && password == "test") {
                    Success(User("", "", ""))
                } else
                    Error("error")
            }

        }
    )


    private val testObject: AuthViewModel = AuthViewModel(authMiddleware, AuthReducer())

    @Before
    fun setup() {
        testObject.bind()
    }

    @Test
    fun tryAuth() = runTest {
        testObject.obtainAction(AuthAction.Login("test", "test"))
        assertEquals(AuthState.SuccessState, testObject.publicState.value)
    }

    @Test
    fun tryAuthFail() = runTest {
        testObject.obtainAction(AuthAction.Login("asd", "ads"))
        assertEquals(AuthState.ErrorState(error = "error"), testObject.stateFlow.value)
    }
}