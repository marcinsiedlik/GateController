package pl.siedlik.gatecontroller.domain.remote

import pl.siedlik.gatecontroller.data.remote.repository.GateRemoteRepository

class OpenGateUseCase(
  private val gateRemoteRepository: GateRemoteRepository,
) {

  suspend operator fun invoke() {
    gateRemoteRepository.openGate()
  }
}
