package com.langfordapps.simplecalories.feature.counter.internal

import com.langfordapps.simplecalories.core.navigation.api.Router
import com.langfordapps.simplecalories.core.shared_test.TestMoleculeConfigProvider
import io.mockk.confirmVerified
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CounterScreenModelTest {

    private val testCoroutineDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setup() = Dispatchers.setMain(testCoroutineDispatcher)

    @AfterTest
    fun testDown() = Dispatchers.resetMain()

    private object Mock {
        val router = mockk<Router>()
    }

    private lateinit var screenModel: CounterScreenModel

    private fun initScreenModel() {
        screenModel = CounterScreenModel(
            router = Mock.router,
            moleculeConfigProvider = TestMoleculeConfigProvider,
        )
    }

    @Test
    fun `should emit initial state`() = runTest {
        initScreenModel()
        val counterState = screenModel.state.value

        assertEquals(expected = 0, actual = counterState.value)
    }

    @Test
    fun `should increment value`() = runTest {
        initScreenModel()
        val initialState = screenModel.state.value

        initialState.onIncrementPressed()

        val newState = screenModel.state.value
        assertEquals(expected = 1, actual = newState.value)
    }

    @Test
    fun `should decrement value`() = runTest {
        initScreenModel()
        val initialState = screenModel.state.value

        initialState.onDecrementPressed()

        val newState = screenModel.state.value
        assertEquals(expected = -1, actual = newState.value)
    }

    @Test
    fun `should navigate back`() = runTest {
        justRun { Mock.router.pop() }
        initScreenModel()
        val initialState = screenModel.state.value

        initialState.onBackPressed()

        verify(exactly = 1) { Mock.router.pop() }
        confirmVerified(Mock.router)
    }
}
