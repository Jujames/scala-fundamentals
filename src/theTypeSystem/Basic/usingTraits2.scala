package theTypeSystem.Basic

import java.io.File
import scala.io.Source

object usingTraits2 extends App {

  trait FileOps {
    self: File =>

    def isTextFile: Boolean = this.getName.endsWith("txt")

    def readText: Iterator[String] =
      if (this.isTextFile)
        Source.fromFile(this).getLines()
      else
        Iterator.empty

    def printLines: Unit =
      this.readText foreach println
  }

  val fooTextFile = new File("./src/m2/foo.txt") with FileOps

  println(fooTextFile.getName)
  println(fooTextFile.isTextFile)
  fooTextFile.printLines

}
