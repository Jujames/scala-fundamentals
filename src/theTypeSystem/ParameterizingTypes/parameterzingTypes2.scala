package theTypeSystem.ParameterizingTypes

import theTypeSystem.ParameterizingTypes.parameterizingTypes.Amount

object parameterizingTypes2 extends App {
  case class Amount(value: Double, currency: String)

  val listOfAmount = List(Amount(4, "USD"), Amount(3, "USD"), Amount(280, "INR"))

  val onlyUSDAmounts =
    listOfAmount.filter(_.currency == "USD")

  onlyUSDAmounts foreach println

  val totalValue = onlyUSDAmounts.foldLeft(0.0)((acc, anotherAmmt) => anotherAmmt.value + acc)

  val totalAmount = Amount(totalValue, "USD")

  println(s"Total Amount in USD is: $totalValue")

}
