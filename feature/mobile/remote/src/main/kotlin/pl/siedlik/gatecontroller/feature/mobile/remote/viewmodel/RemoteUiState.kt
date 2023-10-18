package pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel

internal data class RemoteUiState(
  val status: OperationStatus = OperationStatus.Idle,
  val errorMessages: List<Int> = listOf(),
)

internal enum class OperationStatus {
  Idle,
  Progress,
  Success,
  Failure,
}
