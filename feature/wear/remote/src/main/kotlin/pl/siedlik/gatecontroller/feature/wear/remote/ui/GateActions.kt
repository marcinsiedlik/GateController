package pl.siedlik.gatecontroller.feature.wear.remote.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.siedlik.gatecontroller.ui.common.design.DrawableR
import pl.siedlik.gatecontroller.ui.common.design.StringR

@Composable
internal fun GateActions(
  onOpen: () -> Unit,
  onClose: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier.width(IntrinsicSize.Min),
    verticalArrangement = spacedBy(16.dp),
  ) {
    ActionChip(
      modifier = Modifier.fillMaxWidth(),
      label = stringResource(StringR.open),
      iconPainter = painterResource(DrawableR.ic_gate_open),
      onClick = onOpen,
    )
    ActionChip(
      modifier = Modifier.fillMaxWidth(),
      label = stringResource(StringR.close),
      iconPainter = painterResource(DrawableR.ic_gate_close),
      onClick = onClose,
    )
  }
}

@Preview
@Composable
private fun GateActionsPreview() {
  GateActions(
    onOpen = {},
    onClose = {},
  )
}
