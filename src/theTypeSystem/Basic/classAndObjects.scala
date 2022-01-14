package theTypeSystem.Basic

object classAndObjects extends App {

  class Amount(val value: Double, val currency: String) {
    override def toString: String = s"Amount(${this.value}, ${this.currency}"
  }

  object Amount {
    def apply(value: Double, currency: String): Amount = new Amount(value, currency)

    def apply(value: Double): Amount = new Amount(value, "USD")
  }

  val twoDollars = Amount(2, "USD")
  val twoUSDollars = Amount(2)
  val anotherTwoDollars = Amount(2, "USD")

  println(twoDollars)
  println(twoUSDollars)
  println(twoDollars == anotherTwoDollars)


}
