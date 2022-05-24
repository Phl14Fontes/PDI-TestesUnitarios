package domain.utils

import domain.utils.ParityChecker
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ParityCheckerTest {

    private val parityChecker = ParityChecker()

    //@Test -> NÃO É uma anotação do spring, e sim do jUnit;
    @Test
    fun `should return true when checking if an even number is even`() {
        // Arrange
        val evenNumber = 8

        // Act
        val parityCheckResult = parityChecker.isEven(evenNumber)

        // Assert
        assertTrue(parityCheckResult)
    }

    @Test
    fun `should return true when checking if an odd number is odd`() {
        //Arrange
        val oddNumber = 3

        //Act
        val parityCheckerResult = parityChecker.isOdd(oddNumber)

        //Assert
        assertTrue(parityCheckerResult)
    }

    @Test
    fun `should return false when checking if an even number is odd`() {
        //Arrange
        val evenNumber = 10

        //Act
        val parityCheckerResult = parityChecker.isOdd(evenNumber)

        //Assert
        assertFalse(parityCheckerResult)
    }

    @Test
    fun `should return false when checking if a odd number is even`() {
        //Arrange
        val oddNumber = 3

        //Act
        val parityCheckerResult = parityChecker.isEven(oddNumber)

        //Assert
        assertFalse(parityCheckerResult)

    }

}