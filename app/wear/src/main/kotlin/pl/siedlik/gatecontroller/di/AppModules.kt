package pl.siedlik.gatecontroller.di

import pl.siedlik.gatecontroller.feature.wear.remote.di.featureWearRemoteModule

internal val applicationModules = listOf(
  // Feature modules
  featureWearRemoteModule,
)
