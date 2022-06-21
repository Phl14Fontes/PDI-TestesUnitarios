package domain.service

import domain.exception.InvalidItemAmountException
import domain.model.Order
import domain.model.OrderItem
import domain.model.Product
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class OrderServiceTest {

    private val orderService: OrderService = OrderService()

    @Test
    fun `If given an order, the total value calculation is done correctly`() {
        //arrange
        val product1 = Product("Copo", 7.0, 0.2, 0.3)
        val product2 = Product("Mouse", 20.0, discount = 0.1)
        val product3 = Product("Teclado", 30.0, 0.3, 0.5)
        val product4 = Product("Cadeira", 94.5, 0.25, 0.6, 0.1)

        val orderItem1 = OrderItem(product1, 2) //21
        val orderItem2 = OrderItem(product2, 1) //28
        val orderItem3 = OrderItem(product3, 1) //54
        val orderItem4 = OrderItem(product4, 1) //165,375

        val orderItemsGamer = Order()
        orderItemsGamer.addOrderItem(orderItem1)
        orderItemsGamer.addOrderItem(orderItem2)
        orderItemsGamer.addOrderItem(orderItem3)
        orderItemsGamer.addOrderItem(orderItem4)

        //act
        val totalPrice = orderService.calculateOrderTotalPrice(orderItemsGamer)

        //assert
        assertEquals(268.375, totalPrice)
    }

    @Test
    fun `If the quantity of an order item is less than 1`() {
        //arrange
        val product1 = Product("Secador", 200.0)
        val orderItem1 = OrderItem(product1)
        val orderItemsHair = Order()
        orderItemsHair.addOrderItem(orderItem1)

        //act
        val resultAssert = assertThrows<InvalidItemAmountException> {
            orderService.calculateOrderTotalPrice(orderItemsHair)
        }

        assertEquals("Invalid amount of items!", resultAssert.message)
    }
}