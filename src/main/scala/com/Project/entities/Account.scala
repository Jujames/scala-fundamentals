package main.scala.com.Project.entities

import main.scala.com.Project.entities.Dollars.Zero

import java.util.UUID

sealed trait TransactionType
case object In extends TransactionType
case object Out extends TransactionType

case class Transaction(customer: Customer, amount: Dollars,
                       transactionType: TransactionType, accountCategory: AccountCategory)

sealed trait AccountCategory
case object DepositsA extends AccountCategory
case object LendingA extends AccountCategory

abstract class Account {
  val id: UUID =  UUID.randomUUID()
  val customer: Customer
  val product: Product
  val category: AccountCategory
  var transactions: Seq[Transaction] = Seq.empty

  def getBalance: Dollars
}
class DepositsAccount(val customer: Customer,
                      val product: Deposits,
                      private var balance: Dollars) extends Account {
  override val category: AccountCategory = DepositsA

  def deposit(dollars: Dollars): Unit = {
    require(dollars > Zero, "amount deposited should be greater than zero.")
    balance += dollars
    transactions = transactions :+ Transaction(customer, dollars, In, category)
    println(s"Deposited $dollars to ${this.toString}")
  }
  def withdraw(dollars: Dollars): Unit = {
    require(dollars > Zero && balance > dollars,
      "amount should be greater than zero and the requested amount should be less than or equal to balance,")
    balance -= dollars
    println(s"Withdrawn $dollars from ${this.toString}")
  }

  override def getBalance: Dollars = balance
  override def toString = s"$customer with $product has current balance of $balance"
}

class LendingAccount(val customer: Customer,
                     val product: Lending,
                     private var balance: Dollars) extends Account {
  override val category: AccountCategory = LendingA

  def payBill(dollars: Dollars): Unit = {
    require(dollars > Dollars(0), "The payment must be made for amount greater than zero.")
    balance += dollars
    println(s"Paid bill of $dollars against ${this.toString}")

  }

  def withdraw(dollars: Dollars): Unit = {
    require(dollars > Dollars(0), "The payment must be made for amount greater than zero.")
    println(s"debiting $dollars from $customer")
    balance -= dollars
  }

  override def getBalance: Dollars = balance

  override def toString: String = s"$customer with $product has remaining balance of $balance"

}
