package pl.siedlik.gatecontroller.feature.car.remote.presenter

internal data class RemoteState(
  val action: LoadingAction? = null,
)

internal enum class LoadingAction {
  Open,
  Close,
}
