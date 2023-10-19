package pl.siedlik.gatecontroller.feature.wear.remote.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.siedlik.gatecontroller.domain.remote.CloseGateUseCase
import pl.siedlik.gatecontroller.domain.remote.OpenGateUseCase

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

  private fun performGateAction(action: suspend () -> Result<Unit>) = viewModelScope.launch {
    state.update { state -> state.copy(status = OperationStatus.Progress) }
    val result = action().fold(
      onSuccess = { OperationStatus.Success },
      onFailure = { OperationStatus.Failure },
    )
    state.update { state -> state.copy(status = result) }
  }
}
