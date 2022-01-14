package theTypeSystem.ParameterizingTypes

object Either extends App {
  def saferNumber(possibleNumber: String): Either[String, Int] = {
    try {
      Right(possibleNumber.toInt)
    } catch {
      case e: Throwable =>
        Left(s"${e.getMessage}")
    }
  }

  saferNumber("12") match {
    case Right(number) => println(s"The number: $number")
    case Left(exceptionMsg) => println(s"Something went wrong: $exceptionMsg")
  }

  saferNumber("12")
    .map(number => println(s"The Number: $number"))

  saferNumber("foo")
    .map(number => println(s"The Number: $number"))


}
