package pl.siedlik.gatecontroller.feature.car.remote.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import pl.siedlik.gatecontroller.domain.remote.CloseGateUseCase
import pl.siedlik.gatecontroller.domain.remote.OpenGateUseCase
import pl.siedlik.gatecontroller.ui.common.design.StringR

internal class RemotePresenter(
  private val coroutineScope: CoroutineScope,
  private val openGate: OpenGateUseCase,
  private val closeGate: CloseGateUseCase,
) {

  private val state = MutableStateFlow(RemoteState())
  val stateFlow = state.asStateFlow()

  private val messageEvent = Channel<@receiver:StringRes Int>()
  val messagesFlow = messageEvent.receiveAsFlow()

  fun open() {
    coroutineScope.launch {
      performAction(LoadingAction.Open) { openGate() }
    }
  }

  fun close() {
    coroutineScope.launch {
      performAction(LoadingAction.Close) { closeGate() }
    }
  }

  private suspend fun performAction(type: LoadingAction, action: suspend () -> Result<Unit>) {
    state.update { it.copy(action = type) }
    val resultMessage = action().fold(
      onSuccess = { StringR.ready },
      onFailure = { it.getErrorMessage() },
    )
    messageEvent.send(resultMessage)
    state.update { it.copy(action = null) }
  }

  private fun Throwable.getErrorMessage(): Int = when (this) {
    is NetworkException.ConnectivityException -> StringR.no_internet_connection
    is NetworkException.ServerNotReachableException -> StringR.connectivity_problems
    else -> StringR.unexpected_error
  }
}
