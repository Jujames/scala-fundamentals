package theTypeSystem.Basic

import java.io.File

object usingTraits extends App {
  trait FileOps {
    self: File =>

    def isTextFile: Boolean = this.getName.endsWith("txt")

  }

  val fooTextFile = new File("./src/m2/foo.txt") with FileOps

  println(fooTextFile.getName)
  println(fooTextFile.isTextFile)

}
