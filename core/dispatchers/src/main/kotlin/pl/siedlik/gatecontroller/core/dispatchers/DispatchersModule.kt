package pl.siedlik.gatecontroller.core.dispatchers

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coreDispatchersModule = module {
  single(defaultDispatcher()) { Dispatchers.Default }
  single(ioDispatcher()) { Dispatchers.IO }
}

fun ioDispatcher(): Qualifier = named(AppDispatchers.IO)

fun defaultDispatcher(): Qualifier = named(AppDispatchers.Default)
