package pl.siedlik.gatecontroller.feature.wear.remote.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.MaterialTheme
import kotlinx.coroutines.delay
import pl.siedlik.gatecontroller.feature.wear.remote.viewmodel.OperationStatus
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
internal fun OperationStatusInfo(
  status: OperationStatus,
  onStatusShown: () -> Unit,
  modifier: Modifier = Modifier,
  visibility: Duration = 2.seconds,
) {
  val onStatusCallback by rememberUpdatedState(onStatusShown)

  LaunchedEffect(status) {
    if (!status.isTerminalStatus()) {
      return@LaunchedEffect
    }
    delay(visibility)
    onStatusCallback()
  }

  Crossfade(
    modifier = modifier,
    targetState = status,
    label = "OperationStatus",
  ) { operationStatus ->
    when (operationStatus) {
      OperationStatus.Idle -> Unit
      OperationStatus.Progress -> IndefiniteProgressIndicator()
      OperationStatus.Success -> FullProgressIndicator(color = MaterialTheme.colors.secondaryVariant)
      OperationStatus.Failure -> FullProgressIndicator(color = MaterialTheme.colors.error)
    }
  }
}

@Composable
private fun IndefiniteProgressIndicator() {
  CircularProgressIndicator(
    modifier = Modifier.fillMaxSize(),
    indicatorColor = MaterialTheme.colors.primary,
    strokeWidth = 6.dp,
  )
}

@Composable
private fun FullProgressIndicator(color: Color) {
  CircularProgressIndicator(
    modifier = Modifier.fillMaxSize(),
    indicatorColor = color,
    strokeWidth = 6.dp,
    progress = 1f,
  )
}

private fun OperationStatus.isTerminalStatus() =
  this == OperationStatus.Success || this == OperationStatus.Failure
