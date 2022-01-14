package theTypeSystem.Basic

object classAndObjects1 extends App {
  // added val to parameters
  class Amount(val value: Double, val currency: String) {
    /*
    Use this to access parameters values
    val amountValue = this.value
    val amountCurrency = this.currency
   */
    override def toString: String = s"Amount(${this.value}, ${this.currency})"
  }

  object AmountUtils {
    // converts an amount from the given value to the provided currency
    def convert(from: Amount, to: String): Amount = {

      // Some currencyConversionRates services call which can give the conversion rates
      val conversionRate = 69.45 // Assuming it to 69.45
      new Amount(from.value * conversionRate, to)
    }
  }

  val twoDollars = new Amount(2, "USD")
  val twoDollarsEqINR = AmountUtils.convert(twoDollars, "INR")

  println(twoDollars)
  /*
  println(twoDollars.amountValue)
  println(twoDollars.amountCurrency)
  */

  println(twoDollars.value)
  println(twoDollars.currency)
  println(s"Two Dollars in INR is: $twoDollarsEqINR")
}
