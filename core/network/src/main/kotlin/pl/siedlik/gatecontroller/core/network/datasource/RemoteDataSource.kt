package pl.siedlik.gatecontroller.core.network.datasource

import io.ktor.client.call.DoubleReceiveException
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import kotlinx.coroutines.CancellationException
import pl.siedlik.gatecontroller.core.model.exception.NetworkException
import java.net.SocketException
import java.net.UnknownHostException

interface RemoteDataSource {

  suspend fun <T> ktorCall(call: suspend () -> T): T {
    try {
      return call()
    } catch (e: Exception) {
      when (e) {
        // Coroutine cancellation, passing
        is CancellationException -> throw e
        // Got response from backend with 3xx code
        is RedirectResponseException -> throw NetworkException.ServerNotReachableException()
        // Got response from backend with 3xx-5xx code
        is ResponseException -> throw NetworkException.ErrorResponseException(e.response.status.value)
        // cant connect - server down or no internet connection
        is SocketException, is UnknownHostException -> throw NetworkException.ServerNotReachableException()
        // probably dto is missing @Serializable annotation
        is NoTransformationFoundException -> throw NetworkException.FormatException(e)
        // called body() on response twice
        is DoubleReceiveException -> throw NetworkException.FormatException(e)
        else -> throw NetworkException.UnknownErrorException(e)
      }
    }
  }
}
