package com.example.falshcardsquiz

fun main() {
    val fruits = listOf(
        "Apple",
        "Banana",
        "Carrot",
        "Apricot",
        "Avocado",
        "Cherry",
        "Grape",
        "Kiwi",
        "Lemon",
        "Strawberry",
    )


    for (item in fruits) {
        println(item)
    }

    val denisBankAccount = BankAccount(
        accountHolder ="Denis Panjuta",
        balance = 133.56
    )

    denisBankAccount.deposit(200.00)
    denisBankAccount.deposit(75.75)

 denisBankAccount.displayTransactionHistory()
    println(denisBankAccount.balance)
}