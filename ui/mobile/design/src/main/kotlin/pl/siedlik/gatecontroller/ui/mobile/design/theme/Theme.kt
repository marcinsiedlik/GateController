package pl.siedlik.gatecontroller.ui.mobile.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GateControllerTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    isAtLeastAndroid12() -> dynamicColorScheme(darkTheme = darkTheme)
    darkTheme -> darkColorScheme
    else -> lightColorScheme
  }
  MaterialTheme(
    colorScheme = colorScheme,
    content = content,
  )
}
