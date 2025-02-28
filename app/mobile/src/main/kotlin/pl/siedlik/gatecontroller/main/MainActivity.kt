package pl.siedlik.gatecontroller.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import pl.siedlik.gatecontroller.feature.mobile.remote.ui.RemoteScreen
import pl.siedlik.gatecontroller.ui.mobile.design.theme.GateControllerTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    enableEdgeToEdge()
    super.onCreate(savedInstanceState)
    setComposeContent()
  }

  private fun setComposeContent() = setContent {
    GateControllerTheme {
      RemoteScreen()
    }
  }
}
