package pl.siedlik.gatecontroller.data.remote.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import pl.siedlik.gatecontroller.core.network.status.NetworkStatus
import pl.siedlik.gatecontroller.data.remote.datasource.GateRemoteDataSource

internal class GateRemoteRepositoryImpl(
  private val remoteDataSource: GateRemoteDataSource,
  private val networkStatus: NetworkStatus,
  private val coroutineDispatcher: CoroutineDispatcher,
) : GateRemoteRepository {

  override suspend fun openGate() = withContext(coroutineDispatcher) {
    if (!networkStatus.isInternetAvailable) {
      throw NetworkException.ConnectivityException()
    }
    remoteDataSource.openGate()
  }

  override suspend fun closeGate() = withContext(coroutineDispatcher) {
    if (!networkStatus.isInternetAvailable) {
      throw NetworkException.ConnectivityException()
    }
    remoteDataSource.closeGate()
  }
}
