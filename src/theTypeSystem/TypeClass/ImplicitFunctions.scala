package theTypeSystem.TypeClass

import java.io.File
import scala.io.Source

object ImplicitFunctions extends App {
  type TextLine = String

  def parse(text: Iterator[TextLine]): List[String] = {
    text.map { line =>
      line
        .split(" ")
        .filter(_.length >= 1)
        .map(_.toLowerCase)
        .toList

    }.toList.flatten
  }

  val file = new File("./src/theTypeSystem.TypeClass/foo.txt")
  //val linesOfString: Iterator[String] = Source.fromFile(file).getLines()

  implicit def stringToTextLineIter(str: String): Iterator[TextLine] = Iterator(str)

  val linesOfString: String = "This is a line of String"

  parse(linesOfString) foreach println

}
