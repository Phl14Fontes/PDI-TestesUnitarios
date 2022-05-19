package service

import enums.Parity
import gateway.ParityAPIGateway

class ParityCheckerService(
    private val parityGateway: ParityAPIGateway
) {

    fun checkParity(number: Int): Parity {
        return parityGateway.getParity(number)
    }

}