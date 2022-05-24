package domain.service

import domain.enums.Parity
import resources.gateway.ParityAPIGateway

class ParityCheckerService(
    private val parityGateway: ParityAPIGateway
) {

    fun checkParity(number: Int): Parity {
        return parityGateway.getParity(number)
    }

}