package pl.siedlik.gatecontroller.ui.mobile.design.snackbar

import android.content.Context
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun MessageSnackbarHandler(
  messages: List<Int>,
  snackbarHostState: SnackbarHostState,
  onMessageShown: (Int) -> Unit,
  context: Context = LocalContext.current,
) {
  if (messages.isEmpty()) {
    return
  }
  LaunchedEffect(messages, snackbarHostState) {
    val messageRes = messages.first()
    val message = context.getString(messageRes)
    snackbarHostState.showSnackbar(message)
    onMessageShown(messageRes)
  }
}
