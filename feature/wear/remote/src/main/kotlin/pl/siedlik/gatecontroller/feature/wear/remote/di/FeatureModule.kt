package pl.siedlik.gatecontroller.feature.wear.remote.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import pl.siedlik.gatecontroller.domain.remote.di.domainRemoteModule
import pl.siedlik.gatecontroller.feature.wear.remote.viewmodel.RemoteViewModel

val featureWearRemoteModule = module {
  includes(domainRemoteModule)
  viewModelOf(::RemoteViewModel)
}
