package theTypeSystem.ParameterizingTypes

import scala.util.control.NonFatal

object optionNEither2 extends App {

  def saferNumber(possibleNumber: String): Option[Int] = {
    try {
      Some(possibleNumber.toInt)
    } catch {
      case NonFatal(_) => println(s"Could not convert $possibleNumber to a Number"); None
    }
  }

  // one way to get the value is but this is not safe
  /**   val number = saferNumber("12").get         **/

    // better way is
  val number = saferNumber("12").getOrElse(0)
  println(s"Converted number is $number")

  val fooy = saferNumber("foo").getOrElse(0)
  println(fooy)

}
