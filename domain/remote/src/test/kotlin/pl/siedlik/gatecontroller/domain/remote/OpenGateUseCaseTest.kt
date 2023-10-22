package pl.siedlik.gatecontroller.domain.remote

import io.kotest.matchers.result.shouldBeFailure
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.should
import io.kotest.matchers.throwable.shouldHaveMessage
import io.kotest.matchers.types.beInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.siedlik.gatecontroller.data.remote.repository.GateRemoteRepository
import java.io.IOException

internal class OpenGateUseCaseTest {

  private val gateRemoteRepositoryMock: GateRemoteRepository = mockk()

  private lateinit var testTarget: OpenGateUseCase

  @BeforeEach
  fun setUp() {
    testTarget = OpenGateUseCase(gateRemoteRepositoryMock)
  }

  @Test
  fun `when called open repository method is invoked`() = runTest {
    // arrange
    coEvery { gateRemoteRepositoryMock.openGate() } just runs
    // act
    testTarget()
    // assert
    coVerify(exactly = 1) { gateRemoteRepositoryMock.openGate() }
  }

  @Test
  fun `when repository call returns success result is returned`() = runTest {
    // arrange
    coEvery { gateRemoteRepositoryMock.openGate() } just runs
    // act
    val result = testTarget()
    // assert
    result.shouldBeSuccess()
  }

  @Test
  fun `when repository call throws exception failure result is returned`() = runTest {
    // arrange
    coEvery { gateRemoteRepositoryMock.openGate() } throws IOException("Unexpected error")
    // act
    val result = testTarget()
    // assert
    result.shouldBeFailure { t ->
      t should beInstanceOf<IOException>()
      t shouldHaveMessage "Unexpected error"
    }
  }
}
