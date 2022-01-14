package theTypeSystem.Basic

object caseClass2 extends App {

  case class Amount(value: Double, currency: String)

  val twoDollars = Amount(2, "USD")

  def checkIfDollars(amount: Amount): Boolean =
    amount.currency match {
      case "USD" => println("It's a Dollars."); true
      case _ => println(s"It ain't a Dollar, it's ${amount.currency}."); false
    }

  checkIfDollars(twoDollars)
  checkIfDollars(Amount(2, "INR"))

}
