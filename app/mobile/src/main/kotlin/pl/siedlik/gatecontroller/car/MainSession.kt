package pl.siedlik.gatecontroller.car

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session
import pl.siedlik.gatecontroller.feature.car.remote.ui.RemoteScreen

class MainSession : Session() {

  override fun onCreateScreen(intent: Intent): Screen = RemoteScreen(carContext)
}
