package domain.model

class Order(
    val orderItems: MutableList<OrderItem> = mutableListOf()
) {
    fun addOrderItem(orderItem: OrderItem) = orderItems.add(orderItem)
}