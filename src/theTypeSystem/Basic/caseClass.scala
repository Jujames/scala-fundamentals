package theTypeSystem.Basic

object caseClass extends App {

  case class Amount(value: Double, currency: String)

  val twoDollars = Amount(2, "USD")
  val anotherTwoDollars = Amount(2, "USD")
  val threeDollars = Amount(3, "USD")

  println(twoDollars)
  println(twoDollars.value)
  println(twoDollars.currency)

  println(twoDollars == anotherTwoDollars)
  println(twoDollars == threeDollars)

}
