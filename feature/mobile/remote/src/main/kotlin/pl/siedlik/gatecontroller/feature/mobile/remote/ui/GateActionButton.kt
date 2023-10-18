package pl.siedlik.gatecontroller.feature.mobile.remote.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.siedlik.gatecontroller.ui.common.design.DrawableR

@Composable
internal fun GateActionButton(
  text: String,
  iconPainter: Painter,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Card(modifier = modifier) {
    Column(
      modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = spacedBy(8.dp),
    ) {
      Icon(
        modifier = Modifier.size(48.dp),
        painter = iconPainter,
        tint = MaterialTheme.colorScheme.primary,
        contentDescription = null,
      )
      Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
      )
    }
  }
}

@Preview
@Composable
private fun GateActionButtonPreview() {
  GateActionButton(
    text = "Open",
    iconPainter = painterResource(DrawableR.ic_gate_open),
    onClick = {},
  )
}
