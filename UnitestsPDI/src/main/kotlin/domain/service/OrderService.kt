package domain.service

import domain.exception.InvalidItemAmountException
import domain.model.Order

class OrderService {
    fun calculateOrderTotalPrice(order: Order): Double {
        var totalPrice = 0.0

        order.orderItems.forEach { orderItem ->
            if (orderItem.amount < 1) {
                throw InvalidItemAmountException("Invalid amount of items!")
            }

            totalPrice += orderItem.amount * orderItem.product.price()
        }

        return totalPrice
    }
}