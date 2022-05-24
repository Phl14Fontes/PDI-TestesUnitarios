package domain.repository

import domain.model.Product

class ProductRepository {
    fun save(product: Product) {
        println("Saved!")
    }
}