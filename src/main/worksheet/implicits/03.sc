case class Dollars(amount: Double)

def withTax(dollars: Dollars, taxRate: Double) = Dollars(dollars.amount * (1 + taxRate))

object Conversions {
  implicit def doubleToDollars(d: Double): Dollars = Dollars(d)
}

withTax(Dollars(200), 0.10)

import Conversions._

withTax(200.0, 0.30)

