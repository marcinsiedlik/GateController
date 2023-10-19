package pl.siedlik.gatecontroller.feature.wear.remote.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import pl.siedlik.gatecontroller.ui.common.design.DrawableR

@Composable
internal fun ActionChip(
  label: String,
  iconPainter: Painter,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Chip(
    modifier = modifier,
    onClick = onClick,
    colors = ChipDefaults.secondaryChipColors(),
    icon = {
      Icon(
        tint = MaterialTheme.colors.primary,
        painter = iconPainter,
        contentDescription = null,
      )
    },
    label = {
      Text(
        modifier = Modifier.padding(horizontal = 8.dp),
        text = label,
      )
    },
  )
}

@Preview
@Composable
private fun ActionChipPreview() {
  ActionChip(
    label = "Open",
    iconPainter = painterResource(DrawableR.ic_gate_open),
    onClick = {},
  )
}
