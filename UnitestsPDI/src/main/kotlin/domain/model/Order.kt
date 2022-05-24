package domain.model

class Order(
    val orderItems: MutableList<OrderItem>
) {
    fun addOrderItem(orderItem: OrderItem) = orderItems.add(orderItem)
}