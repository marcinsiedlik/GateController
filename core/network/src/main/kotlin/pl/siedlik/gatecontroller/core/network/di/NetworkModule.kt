package pl.siedlik.gatecontroller.core.network.di

import android.net.ConnectivityManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.AndroidClientEngine
import io.ktor.client.engine.android.AndroidEngineConfig
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import pl.siedlik.gatecontroller.core.network.BuildConfig
import pl.siedlik.gatecontroller.core.network.logger.NetworkLogger
import pl.siedlik.gatecontroller.core.network.status.AndroidNetworkStatus
import pl.siedlik.gatecontroller.core.network.status.NetworkStatus

val coreNetworkModule = module {

  single<ConnectivityManager> { androidContext().getSystemService(ConnectivityManager::class.java) }

  singleOf(::AndroidNetworkStatus) bind NetworkStatus::class

  single<HttpClientEngine> {
    val config = AndroidEngineConfig().apply {
      connectTimeout = 10_000
      socketTimeout = 10_000
    }
    AndroidClientEngine(config)
  }

  single {
    HttpClient(get()) {
      expectSuccess = true
      defaultRequest {
        url(BuildConfig.BASE_URL)
        header(HttpHeaders.Authorization, "Bearer ${BuildConfig.AUTH_TOKEN}")
      }
      if (BuildConfig.DEBUG) {
        install(Logging) {
          logger = NetworkLogger()
          level = LogLevel.ALL
        }
      }
    }
  }
}
