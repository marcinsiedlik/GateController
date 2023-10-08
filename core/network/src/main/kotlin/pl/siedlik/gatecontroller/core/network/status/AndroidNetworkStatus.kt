package pl.siedlik.gatecontroller.core.network.status

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

internal class AndroidNetworkStatus(
  private val connectivityManager: ConnectivityManager,
) : NetworkStatus {

  override val isInternetAvailable: Boolean
    get() = hasActiveNetworkInternetCapability()

  private fun hasActiveNetworkInternetCapability(): Boolean = connectivityManager
    .getNetworkCapabilities(connectivityManager.activeNetwork)
    ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    ?: false
}
