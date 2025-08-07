package com.example.falshcardsquiz


// # Playground for Kotlin Basics
fun main (){
    val listX = listOf(5,3,2,7,8,5)
    var listA = (1..20).toList()
    // # Keep only even numbers
    var listB = listA.filter { it%2==0 }
    var listC = listA.filter { it%2==1 }

    // Trailing lambda syntax with a higher-order function
    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    val result = operateOnNumbers(10, 5) { x, y -> x * y } // Trailing lambda
    println(result) // Output: 50


    println(listA)
    println(listB)
    println(listC)


    printFirstItem(
        list = listOf(1,2,3)
    )

    println( printPow(2,4))
//    println( printPow2(2,8))
    println(getMax(5,3,2,7,8,5 ))
    println(getIndexOf(listX, 7))
    println(getIndexOf(listX, 9))
}

fun getMax(vararg numbers:Int):Int{
    var max = numbers[0]
    for(number in numbers){
        if(number>max){
            max = number
        }
    }
    return max
}

fun printFirstItem(list:List<Int>) = println(list[0])

fun printPow(base:Int, exponent:Int):Int{
    var result = 1
    for(i in 1..exponent){
        result = result * base
    }
    return result
}
fun printPow2(base:Int, exponent:Int):List<Int>{
    // [2, 4, 8, 16, 32, 64, 128, 256]
    var resultList = mutableListOf<Int>()
    var result = 1
    for(i in 1..exponent){
        result = result * base
        resultList.add(result)
    }
    return resultList
}

// Ex. Wire a function to take a list of integers and a value.
//     return the index of the value if its inside the list
fun getIndexOf(list: List<Int>, value : Int): Int {
    for (i in 0..list.size-1){
        if(list[i] == value)
            return i
    }
    return -1
}

fun addOne(numbers: List<Int>): List<Int> {
    return numbers.map{ it + 1 }
}