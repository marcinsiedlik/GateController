package pl.siedlik.gatecontroller.feature.wear.remote.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import org.koin.androidx.compose.koinViewModel
import pl.siedlik.gatecontroller.feature.wear.remote.viewmodel.RemoteUiState
import pl.siedlik.gatecontroller.feature.wear.remote.viewmodel.RemoteViewModel

@Composable
fun RemoteScreen() {
  val viewModel: RemoteViewModel = koinViewModel()
  val state by viewModel.stateFlow.collectAsState()

  RemoteScreen(
    state = state,
    onOpenClick = viewModel::open,
    onCloseClick = viewModel::close,
    onStatusShown = viewModel::operationStatusShown,
  )
}

@Composable
internal fun RemoteScreen(
  state: RemoteUiState,
  onOpenClick: () -> Unit,
  onCloseClick: () -> Unit,
  onStatusShown: () -> Unit,
) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
  ) {
    GateActions(
      onOpen = onOpenClick,
      onClose = onCloseClick,
    )
    OperationStatusInfo(
      status = state.status,
      onStatusShown = onStatusShown,
    )
  }
}

@WearPreviewDevices
@Composable
private fun RemoteScreenPreview() {
  RemoteScreen(
    state = RemoteUiState(),
    onOpenClick = {},
    onCloseClick = {},
    onStatusShown = {},
  )
}
