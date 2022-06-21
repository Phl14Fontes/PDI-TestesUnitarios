package domain.service

import domain.enums.Parity
import domain.service.ParityCheckerService
import resources.gateway.ParityAPIGateway
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ParityCheckerServiceTest {

    // Aqui criamos o mock da classe ParityAPIGateway, a marionete que vai nos obedecer
    private val mockedParityAPIGateway: ParityAPIGateway = mockk()
    // Aqui criamos um objeto real da classe ParityAPIGateway, que vai de fato executar os métodos existentes nela
    private val parityAPIGateway: ParityAPIGateway = ParityAPIGateway()
    // Aqui instanciamos o Service testado com o mock, pra podermos manipular os retornos da classe de Gateway
    private val parityCheckerService: ParityCheckerService = ParityCheckerService(mockedParityAPIGateway)
    // Aqui instanciamos o Service testado com o objeto real, executando de fato todos os métodos da classe de Gateway
    // private val parityCheckerService: ParityCheckerService = ParityCheckerService(parityAPIGateway)

    @Test
    fun `should return EVEN when checking the parity of an even number`() {
        // Arrange
        val evenNumber = 14

        // Essa é a forma como declaramos uma instrução para o mock
        // Sempre que ele encontrar uma chamada igual à que está dentro do bloco `every`, ele vai responder com o
        // que está definido no `returns`
        // Podemos usar o `any()` como parâmetro da chamada do mock pra responder a qualquer parâmetro
        // every { mockedParityAPIGateway.getParity(any()) } returns Parity.EVEN
        every { mockedParityAPIGateway.getParity(evenNumber) } returns Parity.EVEN

        // Act
        val result = parityCheckerService.checkParity(evenNumber)

        // Assert
        assertEquals(Parity.EVEN, result)
    }

    @Test
    fun `should return ODD when checking the parity of an odd number`() {
        // Arrange
        val oddNumber = 15

        every { mockedParityAPIGateway.getParity(oddNumber) } returns Parity.ODD

        // Act
        val result = parityCheckerService.checkParity(oddNumber)

        // Assert
        assertEquals(Parity.ODD, result)
    }

    @Test
    fun `should throw mock exception when trying to add to mocked list`() {
        val mockedList = mockk<MutableList<String>>()

        every { mockedList.add(any()) } returns true

        mockedList.add("one")
        mockedList.add("two")

        every { mockedList.size } returns 2

        assertEquals(2, mockedList.size)
    }

    @Test
    fun `should succeed trying to add to spied list`() {
        val list = mutableListOf<String>()
        val spyList = spyk(list)

        spyList.add("one")
        spyList.add("two")

        // O Spy permite verificação interna do objeto real
        verify(exactly = 2) { spyList.add(any()) }
        assertEquals(2, spyList.size)
    }

    @Test
    fun `should succeed trying to modify a spied list behavior`() {
        val list = mutableListOf<String>()
        val spyList = spyk(list)

        every { spyList.size } returns 2

        assertEquals(2, spyList.size)
    }

}