package pl.siedlik.gatecontroller.feature.mobile.remote.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel.OperationStatus
import pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel.RemoteUiState
import pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel.RemoteViewModel
import pl.siedlik.gatecontroller.ui.common.design.DrawableR
import pl.siedlik.gatecontroller.ui.common.design.StringR
import pl.siedlik.gatecontroller.ui.mobile.design.components.ScreenHeader
import pl.siedlik.gatecontroller.ui.mobile.design.snackbar.MessageSnackbarHandler
import pl.siedlik.gatecontroller.ui.mobile.design.snackbar.rememberSnackbarHostState

@Composable
fun RemoteScreen() {
  val viewModel: RemoteViewModel = koinViewModel()
  val state by viewModel.stateFlow.collectAsStateWithLifecycle()

  RemoteScreen(
    state = state,
    onOpenClick = viewModel::open,
    onCloseClick = viewModel::close,
    onStatusShown = viewModel::operationStatusShown,
    onMessageShown = viewModel::errorMessageShown,
  )
}

@Composable
internal fun RemoteScreen(
  state: RemoteUiState,
  onOpenClick: () -> Unit,
  onCloseClick: () -> Unit,
  onStatusShown: () -> Unit,
  onMessageShown: (Int) -> Unit,
) {
  val snackbarHostState = rememberSnackbarHostState()

  MessageSnackbarHandler(
    messages = state.errorMessages,
    snackbarHostState = snackbarHostState,
    onMessageShown = onMessageShown,
  )

  Scaffold(
    topBar = {
      ScreenHeader(
        modifier = Modifier.systemBarsPadding(),
        title = stringResource(StringR.gate_control),
        iconPainter = painterResource(DrawableR.ic_gate),
      )
    },
    snackbarHost = {
      SnackbarHost(hostState = snackbarHostState)
    },
  ) { paddingValues ->
    Column(
      modifier = Modifier.padding(paddingValues),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Box(modifier = Modifier.weight(1f)) {
        OperationStatusTile(
          status = state.status,
          onStatusShown = onStatusShown,
        )
      }
      GateActions(
        modifier = Modifier
          .navigationBarsPadding()
          .padding(bottom = 88.dp),
        onOpenClick = onOpenClick,
        onCloseClick = onCloseClick,
      )
    }
  }
}

@Preview
@Composable
private fun RemoteScreenPreview() {
  RemoteScreen(
    state = RemoteUiState(
      status = OperationStatus.Idle,
      errorMessages = listOf(),
    ),
    onOpenClick = {},
    onCloseClick = {},
    onStatusShown = {},
    onMessageShown = {},
  )
}
