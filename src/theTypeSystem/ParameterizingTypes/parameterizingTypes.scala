package theTypeSystem.ParameterizingTypes

object parameterizingTypes extends App {
  def interest(p: Double, r: Double, t: Int): Double = p * r * t

  val i = interest(2000, 0.07, 2)

  println(s"interest is: ${i}")
// Higher order Function
  val foo = "foo"
  val bar = 12
  val increment = (x: Int) => x + 1

  println(s"incremented bar value is : ${increment(bar)}")

  def interestReport(p: Double, r: Double, t: Double,
                     calc: (Double, Double, Double) => Double): Double = calc(p, t, r)

  val simpleInterest = (p: Double, r: Double, t: Double) => p * r * t

  val compoundInterest = (p: Double, r: Double, t: Double) => (p * (Math.pow((1 + r), t))) - p

  val resultSimple = interestReport(2000, 0.07, 2, simpleInterest)
  val resultCompound = interestReport(2000, 0.07, 2, compoundInterest)

  println(s"Simple Interest is: $resultSimple")
  println(s"Compound Interest is: $resultCompound")

  case class Amount(value: Double, currency: String)

  val listOfAmount = List(Amount(4, "USD"), Amount(3, "USD"), Amount(280, "INR"))

  val usdConverter = (toBeConverted: Amount) => {
    toBeConverted.currency match {
      case "USD" => toBeConverted
      case _ => Amount(toBeConverted.value * 0.014, "USD") //
      // Get the exchange rate from amount.currency to USD e.g INR/USD 0.014
    }
  }

  val amountInUSD = listOfAmount.map(usdConverter)

  val isUSD = (amount: Amount) => amount.currency == "USD"

  val onlyUSDAmounts =
    listOfAmount.filter(isUSD)


  amountInUSD foreach println
  onlyUSDAmounts foreach println

}

