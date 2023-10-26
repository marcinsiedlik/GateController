package pl.siedlik.gatecontroller.feature.car.remote.di

import org.koin.dsl.module
import pl.siedlik.gatecontroller.domain.remote.di.domainRemoteModule
import pl.siedlik.gatecontroller.feature.car.remote.presenter.RemotePresenter

val featureCarRemoteModule = module {
  includes(domainRemoteModule)
  factory { params -> RemotePresenter(params.get(), get(), get()) }
}
