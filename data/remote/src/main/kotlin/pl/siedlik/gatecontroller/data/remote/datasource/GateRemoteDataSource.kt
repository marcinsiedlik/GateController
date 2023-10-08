package pl.siedlik.gatecontroller.data.remote.datasource

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import pl.siedlik.gatecontroller.core.network.datasource.RemoteDataSource

internal class GateRemoteDataSource(
  private val httpClient: HttpClient,
) : RemoteDataSource {

  suspend fun openGate(): Unit = ktorCall {
    httpClient.post("open")
  }

  suspend fun closeGate(): Unit = ktorCall {
    httpClient.post("close")
  }
}
