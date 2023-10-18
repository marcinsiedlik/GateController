package pl.siedlik.gatecontroller.feature.mobile.remote.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel.OperationStatus
import pl.siedlik.gatecontroller.ui.common.design.StringR
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
internal fun OperationStatusTile(
  status: OperationStatus,
  onStatusShown: () -> Unit,
  visibility: Duration = 2.seconds,
) {
  LaunchedEffect(status) {
    if (!status.isTerminalStatus()) {
      return@LaunchedEffect
    }
    delay(visibility)
    onStatusShown()
  }

  Crossfade(
    targetState = status,
    label = "OperationStatus",
  ) { targetStatus ->
    Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center,
    ) {
      when (targetStatus) {
        OperationStatus.Idle -> Unit
        OperationStatus.Progress -> CircularProgressIndicator(
          color = MaterialTheme.colorScheme.secondary
        )

        OperationStatus.Success -> SuccessIcon()
        OperationStatus.Failure -> ErrorIcon()
      }
    }
  }
}

@Composable
private fun SuccessIcon() {
  Icon(
    modifier = Modifier.size(48.dp),
    imageVector = Icons.Outlined.CheckCircle,
    tint = MaterialTheme.colorScheme.tertiary,
    contentDescription = stringResource(StringR.success_icon),
  )
}

@Composable
private fun ErrorIcon() {
  Icon(
    modifier = Modifier.size(48.dp),
    imageVector = Icons.Outlined.Clear,
    tint = MaterialTheme.colorScheme.error,
    contentDescription = stringResource(StringR.failure_icon),
  )
}

private fun OperationStatus.isTerminalStatus() =
  this == OperationStatus.Success || this == OperationStatus.Failure
