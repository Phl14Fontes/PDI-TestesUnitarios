package utils

class ParityChecker {

    fun isOdd(integer: Int): Boolean {
         if(integer % 2 != 0){
             return true
         }else {
             return false
         }
    }

    //retorna 2 caminhos para testes unitários (feliz e triste) - true | false;
    fun isEven(integer: Int): Boolean {
        return (integer % 2 == 0)
    }

}