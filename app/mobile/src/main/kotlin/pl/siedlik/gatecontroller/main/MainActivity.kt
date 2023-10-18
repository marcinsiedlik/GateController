package pl.siedlik.gatecontroller.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import pl.siedlik.gatecontroller.feature.mobile.remote.ui.RemoteScreen
import pl.siedlik.gatecontroller.ui.mobile.design.theme.GateControllerTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    installSplashScreen()
    setDecorFitsSystemWindows()
    setComposeContent()
  }

  private fun setComposeContent() = setContent {
    GateControllerTheme {
      RemoteScreen()
    }
  }

  private fun setDecorFitsSystemWindows() {
    WindowCompat.setDecorFitsSystemWindows(window, false)
  }
}
