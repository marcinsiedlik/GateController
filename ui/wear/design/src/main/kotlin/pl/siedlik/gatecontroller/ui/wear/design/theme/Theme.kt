package pl.siedlik.gatecontroller.ui.wear.design.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme

@Composable
fun GateControllerTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colors = wearColorPalette,
    content = content,
  )
}
