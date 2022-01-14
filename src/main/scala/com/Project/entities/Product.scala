package main.scala.com.Project.entities
import java.util.UUID

sealed trait  ProductCategory
case object DepositsP extends ProductCategory
case object LendingP extends ProductCategory


abstract class Product {
  val id: UUID = UUID.randomUUID()
  val category: ProductCategory
  val name: String

  override def toString: String = "product=" + name
}

/* ----------- Deposit Products ---------------------- */
abstract class Deposits extends Product {
  override val category: ProductCategory = DepositsP
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Dollars
}

abstract class Checkings extends Deposits

abstract class Saving extends Deposits {
  val transactionsAllowedPerMonth: Int

}

/* --------------- Checkings Products ------------------------------ */
class CoreChecking(val minimumBalancePerMonth: Dollars,
                   val interestRatePerYear: Double) extends Checkings {
  println("Created Core Checking Products")
  override val name: String = "Core Checking"
}

class StudentCheckings(val minimumBalancePerMonth: Dollars,
                        val interestRatePerYear: Double) extends Checkings{
  println("Created Student Checking Products")
  override val name: String = "Student Checkings"
}

/* ---------------- Saving Products --------------------------- */
class RewardsSavings(val minimumBalancePerMonth: Dollars,
                     val interestRatePerYear: Double, val trans: Int) extends Saving {
  println("Created Rewards Saving Products")
  override val transactionsAllowedPerMonth: Int = trans
  override val name: String = "Rewards Savings"
}

/* --------------- Lending Products ------------------------- */
abstract class Lending extends Product {
  override val category: ProductCategory = LendingP
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(fee: Double, rate: Double, pct: Double) extends Lending {
  println("Created Credit Card Product")
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardsPercent: Double = pct
  override val name: String = "Credit Card"
}
