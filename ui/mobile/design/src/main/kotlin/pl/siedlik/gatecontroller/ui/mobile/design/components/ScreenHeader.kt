package pl.siedlik.gatecontroller.ui.mobile.design.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
fun ScreenHeader(
  title: String,
  iconPainter: Painter,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(
        vertical = 36.dp,
        horizontal = 24.dp,
      ),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Icon(
      modifier = Modifier.size(36.dp),
      painter = iconPainter,
      tint = MaterialTheme.colorScheme.primary,
      contentDescription = null,
    )
    Text(
      text = title,
      style = MaterialTheme.typography.titleMedium,
    )
  }
}

@Preview
@Composable
private fun ScreenHeaderPreview() {
  Surface {
    ScreenHeader(
      title = "Gate remote",
      iconPainter = painterResource(DrawableR.ic_gate),
    )
  }
}
