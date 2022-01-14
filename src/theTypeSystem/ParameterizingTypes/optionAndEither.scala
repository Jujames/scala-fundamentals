package theTypeSystem.ParameterizingTypes

import scala.util.control.NonFatal

object optionAndEither extends App {

 def safeNumber(possibleNumber: String): Int = {
    try {
   possibleNumber.toInt
   } catch {
     case NonFatal(_) => throw new Exception
     }
   }
   def double(number: Int): Int = number * 2

    val doubled12 = double(safeNumber("12"))
   println(s"Converted number is ${safeNumber("12")}")
   println(s"Doubled number is $doubled12")
 }

