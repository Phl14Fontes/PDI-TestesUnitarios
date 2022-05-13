package utils

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ParityCheckerTest {

    //@Test -> NÃO É uma anotação do spring, e sim do jUnit;
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

    @Test
    fun `should return true when checking if an odd number is odd`() {
        //Arrange
        val oddNumber = 3
        val parityChecker = ParityChecker()

        //Act
        val parityCheckerResult = parityChecker.isOdd(oddNumber)

        //Assert
        assertTrue(parityCheckerResult)
    }

    @Test
    fun `should return false when checking if an even number is odd`() {
        //Arrange
        val evenNumber = 10
        val parityChecker = ParityChecker()

        //Act
        val parityCheckerResult = parityChecker.isOdd(evenNumber)

        //Assert
        assertFalse(parityCheckerResult)
    }

    @Test
    fun `should return false when checking if a odd number is even`() {
        //Arrange
        val oddNumber = 3
        val parityChecker = ParityChecker()

        //Act
        val parityCheckerResult = parityChecker.isEven(oddNumber)

        //Assert
        assertFalse(parityCheckerResult)

    }

}