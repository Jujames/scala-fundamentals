import scala.language.implicitConversions
import scala.language.postfixOps

case class Dollars(amount: Int) {
  def prettify: String = "$" + amount
}

implicit def doubleToDollars(d: Int): Dollars = Dollars(d)

val customerBalance: Int = 1000

customerBalance prettify


