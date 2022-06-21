package domain.model

class Order(
    val orderItems: MutableList<OrderItem> = mutableListOf()
) {
    var totalPrice: Double = 0.0
    fun addOrderItem(orderItem: OrderItem) {
        orderItems.add(orderItem)
    }

    fun incrementTotalPrice(orderItem: OrderItem) {
        totalPrice += orderItem.totalPrice()
    }

}