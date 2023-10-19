package pl.siedlik.gatecontroller.feature.wear.remote.viewmodel

internal data class RemoteUiState(
  val status: OperationStatus = OperationStatus.Idle,
)

internal enum class OperationStatus {
  Idle,
  Progress,
  Success,
  Failure,
}
