package pl.siedlik.gatecontroller.feature.mobile.remote.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
  onOpenClick: () -> Unit,
  onCloseClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier = modifier.padding(horizontal = 16.dp),
    horizontalArrangement = spacedBy(8.dp),
  ) {
    GateActionButton(
      modifier = Modifier.weight(1f),
      iconPainter = painterResource(DrawableR.ic_gate_close),
      text = stringResource(StringR.close),
      onClick = onCloseClick,
    )
    GateActionButton(
      modifier = Modifier.weight(1f),
      iconPainter = painterResource(DrawableR.ic_gate_open),
      text = stringResource(StringR.open),
      onClick = onOpenClick,
    )
  }
}

@Preview
@Composable
private fun GateActionsPreview() {
  GateActions(
    onOpenClick = {},
    onCloseClick = {},
  )
}
