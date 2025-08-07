package com.example.falshcardsquiz

class BankAccount(var accountHolder: String , var balance:Double) {
    private val transactionHistory = mutableListOf<String>()


    fun deposit(amount: Double){
        balance += amount
        transactionHistory.add("$accountHolder deposited $$amount")

    }
    fun withdraw(amount: Double){
         if(amount<=balance){
             // we can withdraw
             balance-= amount
             transactionHistory.add("$accountHolder withdrew $$amount")
         } else {
             // we can not withdraw money
             println("You do not have the funds to withdraw $$amount")
         }
    }
    fun displayTransactionHistory(){
        println("----- Transaction history for $accountHolder -----")
        for(transaction in transactionHistory){
            println(transaction)
        }

    }
}