package pl.siedlik.gatecontroller.feature.wear.remote.viewmodel

import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import pl.siedlik.gatecontroller.domain.remote.CloseGateUseCase
import pl.siedlik.gatecontroller.domain.remote.OpenGateUseCase

@OptIn(ExperimentalCoroutinesApi::class)
internal class RemoteViewModelTest {

  private val openGateMock: OpenGateUseCase = mockk()
  private val closeGateMock: CloseGateUseCase = mockk()

  private lateinit var testTarget: RemoteViewModel

  @BeforeEach
  fun setUp() {
    Dispatchers.setMain(UnconfinedTestDispatcher())
    testTarget = RemoteViewModel(
      openGate = openGateMock,
      closeGate = closeGateMock,
    )
  }

  @AfterEach
  fun tearDown() {
    Dispatchers.resetMain()
  }

  @Test
  fun `when open gate is performed state is updated`() = runTest {
    // arrange
    coEvery { openGateMock() } returns Result.success(Unit)
    testTarget.stateFlow.test {
      // act
      testTarget.open()
      // assert
      awaitItem() shouldBe RemoteUiState()
      awaitItem() shouldBe RemoteUiState(status = OperationStatus.Success)
    }
  }

  @Test
  fun `when open gate fails with network exception state is updated`() = runTest {
    // arrange
    coEvery { openGateMock() } returns Result.failure(NetworkException.ConnectivityException())
    testTarget.stateFlow.test {
      // act
      testTarget.open()
      // assert
      awaitItem() shouldBe RemoteUiState()
      awaitItem() shouldBe RemoteUiState(status = OperationStatus.Failure)
    }
  }

  @Test
  fun `when status is shown state is updated`() = runTest {
    // arrange
    coEvery { openGateMock() } returns Result.success(Unit)
    testTarget.open()
    testTarget.stateFlow.test {
      // act
      testTarget.operationStatusShown()
      awaitItem() shouldBe RemoteUiState(status = OperationStatus.Success)
      awaitItem() shouldBe RemoteUiState(status = OperationStatus.Idle)
    }
  }
}
