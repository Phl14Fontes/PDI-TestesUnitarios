package domain.repository

import domain.model.Product

class ProductRepository {
    // Esse método save vai salvar as informações de um produto no banco de dados
    fun save(product: Product) {
        println("Saved!")
    }
}