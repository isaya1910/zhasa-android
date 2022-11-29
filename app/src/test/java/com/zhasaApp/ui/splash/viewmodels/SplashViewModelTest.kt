package com.zhasaApp.ui.splash.viewmodels

import com.zhasaApp.repository.auth.AuthRepository
import com.zhasaApp.repository.models.AuthState
import com.zhasaApp.repository.result.RequestResult
import com.zhasaApp.ui.common.viewmodel.DispatcherProvider
import com.zhasaApp.ui.login.viewmodels.MainCoroutineRule
import com.zhasaApp.ui.splash.models.SplashAction
import com.zhasaApp.ui.splash.models.SplashMiddleWare
import com.zhasaApp.ui.splash.models.SplashReducer
import com.zhasaApp.ui.splash.models.SplashState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val splashMiddleWare = SplashMiddleWare(
        object : AuthRepository {
            override val user: StateFlow<AuthState>
                get() = TODO("Not yet implemented")

            override suspend fun authenticate(
                email: String,
                password: String
            ): RequestResult<AuthState.SignIn> {
                if (email == "test" && password == "test") {
                    return RequestResult.Success(AuthState.SignIn(""))
                }

                return RequestResult.Error("error")
            }

            override suspend fun authState(): AuthState {
                return AuthState.SignIn("")
            }
        }
    )

    private val testObject: SplashViewModel = SplashViewModel(
        splashMiddleWare,
        SplashReducer(),
        object : DispatcherProvider {
            override val io: CoroutineDispatcher = UnconfinedTestDispatcher()
            override val main: CoroutineDispatcher = UnconfinedTestDispatcher()
        }
    )

    @Before
    fun setup() {
        testObject.bind()
    }

    @Test
    fun userSignIn() = runTest(UnconfinedTestDispatcher()) {
        val expected = listOf(SplashState.InitialState, SplashState.MainState)
        val actual = mutableListOf<SplashState>()

        val job = testObject.stateFlow.onEach {
            actual.add(it)
        }.launchIn(this)

        testObject.obtainAction(SplashAction.CheckAuthState)

        Assert.assertEquals(expected, actual)
        job.cancel()
    }
}
