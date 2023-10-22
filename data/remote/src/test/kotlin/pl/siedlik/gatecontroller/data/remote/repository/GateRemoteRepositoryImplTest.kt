package pl.siedlik.gatecontroller.data.remote.repository

import io.kotest.assertions.throwables.shouldThrow
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import pl.siedlik.gatecontroller.core.network.status.NetworkStatus
import pl.siedlik.gatecontroller.data.remote.datasource.GateRemoteDataSource

@OptIn(ExperimentalCoroutinesApi::class)
internal class GateRemoteRepositoryImplTest {

  private val remoteDataSourceMock: GateRemoteDataSource = mockk()
  private val networkStatusMock: NetworkStatus = mockk()

  private lateinit var testTarget: GateRemoteRepositoryImpl

  @BeforeEach
  fun setUp() {
    testTarget = GateRemoteRepositoryImpl(
      remoteDataSource = remoteDataSourceMock,
      networkStatus = networkStatusMock,
      coroutineDispatcher = UnconfinedTestDispatcher(),
    )
  }

  @Test
  fun `when there is no internet connection on open exception is thrown`() = runTest {
    // arrange
    every { networkStatusMock.isInternetAvailable } returns false
    // act & assert
    shouldThrow<NetworkException.ConnectivityException> {
      testTarget.openGate()
    }
  }

  @Test
  fun `when datasource returns on open repository returns`() = runTest {
    // arrange
    every { networkStatusMock.isInternetAvailable } returns true
    coEvery { remoteDataSourceMock.openGate() } just runs
    // act
    testTarget.openGate()
    // assert
    coVerify(exactly = 1) { remoteDataSourceMock.openGate() }
  }


  @Test
  fun `when there is no internet connection on close exception is thrown`() = runTest {
    // arrange
    every { networkStatusMock.isInternetAvailable } returns false
    // act & assert
    shouldThrow<NetworkException.ConnectivityException> {
      testTarget.closeGate()
    }
  }

  @Test
  fun `when datasource returns on close repository returns`() = runTest {
    // arrange
    every { networkStatusMock.isInternetAvailable } returns true
    coEvery { remoteDataSourceMock.closeGate() } just runs
    // act
    testTarget.closeGate()
    // assert
    coVerify(exactly = 1) { remoteDataSourceMock.closeGate() }
  }
}
