package domain.model

class Product(
    private val name: String,
    private val factoryCost: Double,
    private val taxes: Double = 0.2,
    private val profit: Double = 0.3,
    private val discount: Double = 0.0
) {
    fun price() = factoryCost * (1 + taxes + profit - discount)
}