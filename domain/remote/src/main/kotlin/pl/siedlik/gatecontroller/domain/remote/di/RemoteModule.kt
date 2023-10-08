package pl.siedlik.gatecontroller.domain.remote.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import pl.siedlik.gatecontroller.data.remote.di.dataRemoteModule
import pl.siedlik.gatecontroller.domain.remote.CloseGateUseCase
import pl.siedlik.gatecontroller.domain.remote.OpenGateUseCase

val domainRemoteModule = module {
  includes(dataRemoteModule)

  factoryOf(::OpenGateUseCase)
  factoryOf(::CloseGateUseCase)
}
