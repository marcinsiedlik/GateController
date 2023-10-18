package pl.siedlik.gatecontroller.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.siedlik.gatecontroller.di.applicationModules

internal class App : Application() {

  override fun onCreate() {
    super.onCreate()
    initDependencyInjection()
  }

  private fun initDependencyInjection() {
    startKoin {
      androidContext(this@App)
      modules(applicationModules)
    }
  }
}
