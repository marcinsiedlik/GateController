package pl.siedlik.gatecontroller.di

import pl.siedlik.gatecontroller.feature.car.remote.di.featureCarRemoteModule
import pl.siedlik.gatecontroller.feature.mobile.remote.di.featureMobileRemoteModule

internal val applicationModules = listOf(
  // Feature modules
  featureCarRemoteModule,
  featureMobileRemoteModule,
)
