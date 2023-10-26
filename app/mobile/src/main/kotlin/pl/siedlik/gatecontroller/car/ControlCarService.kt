package pl.siedlik.gatecontroller.car

import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import pl.siedlik.gatecontroller.BuildConfig
import pl.siedlik.gatecontroller.core.car.CarArrayR

internal class ControlCarService : CarAppService() {

  override fun createHostValidator(): HostValidator {
    if (BuildConfig.DEBUG) {
      return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }
    return HostValidator.Builder(applicationContext).run {
      addAllowedHosts(CarArrayR.car_hosts_allowlist)
      build()
    }
  }

  override fun onCreateSession(): Session = MainSession()
}
