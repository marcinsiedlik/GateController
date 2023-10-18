package pl.siedlik.gatecontroller.ui.mobile.design.snackbar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberSnackbarHostState(): SnackbarHostState = remember {
  SnackbarHostState()
}
