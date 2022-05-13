package utils

class AnotherParityChecker (
    private val value: Int
) {

    fun isOdd(): Boolean {
        return (value % 2 != 0)
    }

    fun isEven(): Boolean {
        return (value % 2 == 0)
    }

}