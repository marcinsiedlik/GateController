package pl.siedlik.gatecontroller.feature.mobile.remote.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import pl.siedlik.gatecontroller.domain.remote.di.domainRemoteModule
import pl.siedlik.gatecontroller.feature.mobile.remote.viewmodel.RemoteViewModel

val featureMobileRemoteModule = module {
  includes(domainRemoteModule)
  viewModelOf(::RemoteViewModel)
}
