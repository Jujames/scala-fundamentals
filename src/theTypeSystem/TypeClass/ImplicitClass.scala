package theTypeSystem.TypeClass

import java.io.File
import scala.io.Source

object ImplicitClass extends App {

 object Implicits {
   implicit class FileExt(file: File) {

     def isTextFile: Boolean = file.getName.endsWith("txt")

     def readText: Iterator[String] =
       if (isTextFile)
        Source.fromFile(file).getLines()
       else
        Iterator.empty

     def printLines: Unit =
      readText foreach println

    }
  }

  import Implicits._

  val fooFile = new File("./src/module6/foo.txt")

  val fooFileName = fooFile.getName
  println(s"File name is: $fooFileName")

  val isFooTextFile = fooFile.isTextFile
  println(s"Is fooFile is a Text File: $isFooTextFile")

  fooFile.printLines

}
