package pl.siedlik.gatecontroller.core.network.logger

import io.ktor.client.plugins.logging.Logger

internal class NetworkLogger : Logger {

  override fun log(message: String) {
    println("$LOG_TAG: $message")
  }

  companion object {
    private const val LOG_TAG = "HttpClient"
  }
}
