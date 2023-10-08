package pl.siedlik.gatecontroller.domain.remote

import pl.siedlik.gatecontroller.data.remote.repository.GateRemoteRepository

class CloseGateUseCase(
  private val gateRemoteRepository: GateRemoteRepository,
) {

  suspend operator fun invoke() {
    gateRemoteRepository.closeGate()
  }
}
