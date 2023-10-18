package pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import pl.siedlik.gatecontroller.domain.remote.CloseGateUseCase
import pl.siedlik.gatecontroller.domain.remote.OpenGateUseCase
import pl.siedlik.gatecontroller.ui.common.design.StringR

internal class RemoteViewModel(
  private val openGate: OpenGateUseCase,
  private val closeGate: CloseGateUseCase,
) : ViewModel() {

  private val state = MutableStateFlow(RemoteUiState())
  val stateFlow = state.asStateFlow()

  fun open() {
    performGateAction { openGate() }
  }

  fun close() {
    performGateAction { closeGate() }
  }

  fun operationStatusShown() = state.update { state ->
    state.copy(status = OperationStatus.Idle)
  }

  fun errorMessageShown(errorMessage: Int) = state.update { state ->
    state.copy(errorMessages = state.errorMessages - errorMessage)
  }

  private fun performGateAction(action: suspend () -> Result<Unit>) = viewModelScope.launch {
    state.update { state -> state.copy(status = OperationStatus.Progress) }
    val result = action()
    when {
      result.isSuccess -> state.update { state ->
        state.copy(status = OperationStatus.Success)
      }
      else -> state.update { state ->
        state.copy(
          status = OperationStatus.Failure,
          errorMessages = state.errorMessages + result.exceptionOrNull().getErrorMessage(),
        )
      }
    }
  }

  private fun Throwable?.getErrorMessage(): Int = when (this) {
    is NetworkException.ConnectivityException -> StringR.no_internet_connection
    is NetworkException.ServerNotReachableException -> StringR.connectivity_problems
    else -> StringR.unexpected_error
  }
}
