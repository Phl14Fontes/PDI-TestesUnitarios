package domain.service

import domain.model.Product
import domain.repository.ProductRepository
import io.mockk.*
import org.junit.jupiter.api.Test

class ProductServiceTest {

    private val mockedProductRepository: ProductRepository = mockk()

    private val productService: ProductService = ProductService(mockedProductRepository)

    @Test
    fun `if the service calls the repository when saving the product`() {
        //Arrange
        val product = Product("Copo", 5.0)
        //just runs -> mock, só executa sem retorno
        every { mockedProductRepository.save(product) } just runs

        //Act
        productService.save(product)

        //Assert
        verify (exactly = 1) { mockedProductRepository.save(product) }
        //verify (atLeast = 1) -> Pelo menos uma vez, eficiente para listas que não se sabe o tamanho da lista
        //verify (atMost = 1) -> No máximo uma vez, pouca usabilidade
        //verify (atLeast = 1, atMost = 3) -> verificação dentro de um range (min - max)
    }
}