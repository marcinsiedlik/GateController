package pl.siedlik.gatecontroller.data.remote.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import pl.siedlik.gatecontroller.core.dispatchers.coreDispatchersModule
import pl.siedlik.gatecontroller.core.dispatchers.ioDispatcher
import pl.siedlik.gatecontroller.core.network.di.coreNetworkModule
import pl.siedlik.gatecontroller.data.remote.datasource.GateRemoteDataSource
import pl.siedlik.gatecontroller.data.remote.repository.GateRemoteRepository
import pl.siedlik.gatecontroller.data.remote.repository.GateRemoteRepositoryImpl

val dataRemoteModule = module {
  includes(coreDispatchersModule, coreNetworkModule)

  singleOf(::GateRemoteDataSource)
  single<GateRemoteRepository> { GateRemoteRepositoryImpl(get(), get(), get(ioDispatcher())) }
}
