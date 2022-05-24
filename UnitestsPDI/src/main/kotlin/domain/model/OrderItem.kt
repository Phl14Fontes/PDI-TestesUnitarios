package domain.model

class OrderItem(
    private val product: Product,
    val amount: Int = 0
) {
    fun totalPrice() = amount * product.price()
}