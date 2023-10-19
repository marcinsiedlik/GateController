package pl.siedlik.gatecontroller.ui.wear.design.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration

@Composable
@ReadOnlyComposable
fun isRoundDevice(): Boolean = LocalConfiguration.current.isScreenRound
