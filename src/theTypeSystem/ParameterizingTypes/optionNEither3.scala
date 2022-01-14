package theTypeSystem.ParameterizingTypes

import scala.util.control.NonFatal

object optionNEither3 extends App {

  def saferNumber(possibleNumber: String): Option[Int] = {
    try {
      Some(possibleNumber.toInt)
    } catch {
      case NonFatal(_) => println(s"Could not convert $possibleNumber to a Number"); None
    }
  }

  def double(number: Int): Int = number * 2

  saferNumber("12") match {
    case Some(number) => println(s"The number: $number")
    case None => println("Could not convert the number")
  }
  /*
    .map(double)
    .foreach(double12 => println(s"Doubled number is: $double12"))

   */
}