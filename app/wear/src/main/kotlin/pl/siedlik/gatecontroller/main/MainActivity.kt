package pl.siedlik.gatecontroller.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import pl.siedlik.gatecontroller.feature.wear.remote.ui.RemoteScreen
import pl.siedlik.gatecontroller.ui.wear.design.theme.GateControllerTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    setComposeContent()
  }

  private fun setComposeContent() = setContent {
    GateControllerTheme {
      RemoteScreen()
    }
  }
}
