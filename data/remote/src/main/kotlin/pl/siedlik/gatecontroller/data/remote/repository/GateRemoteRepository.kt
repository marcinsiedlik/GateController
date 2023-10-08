package pl.siedlik.gatecontroller.data.remote.repository

interface GateRemoteRepository {

  suspend fun openGate()

  suspend fun closeGate()
}
