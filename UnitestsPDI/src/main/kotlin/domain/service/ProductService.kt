package domain.service

import domain.model.Product
import domain.repository.ProductRepository

class ProductService(
    private val productRepository: ProductRepository
) {
    fun save(product: Product) {
        productRepository.save(product)
    }
}