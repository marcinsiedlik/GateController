package pl.siedlik.gatecontroller.core.model.exception

import java.io.IOException

sealed class NetworkException(cause: Throwable? = null) : IOException(cause) {

  class ConnectivityException : NetworkException()

  class ServerNotReachableException : NetworkException()

  class FormatException(cause: Throwable?) : NetworkException(cause)

  class UnknownErrorException(cause: Throwable?) : NetworkException(cause)

  class ErrorResponseException(val errorCode: Int) : NetworkException()
}
