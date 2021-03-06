package domain.utils

import domain.utils.ParityChecker
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AnotherParityCheckerTest {

    @Test
    fun `should return true when checking if an even number is even`() {
        // Arrange
        val evenNumber = 8
        val parityChecker = ParityChecker()

        // Act
        val parityCheckResult = parityChecker.isEven(evenNumber)

        // Assert
        assertTrue(parityCheckResult)
    }

}