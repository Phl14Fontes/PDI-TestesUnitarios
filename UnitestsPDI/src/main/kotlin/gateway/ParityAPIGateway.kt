package gateway

import enums.Parity

class ParityAPIGateway {

    fun getParity(number: Int): Parity {
        // Vai numa API externa, faz uma request HTTP e retorna o resultado.
        // Finge que o código abaixo vai fazer isso...
        return if (number % 2 == 0) {
            Parity.EVEN
        } else {
            Parity.ODD
        }
    }

}