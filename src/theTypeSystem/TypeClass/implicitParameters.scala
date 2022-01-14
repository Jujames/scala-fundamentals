package theTypeSystem.TypeClass

import java.io.File

object implicitParameters extends App {
  import Implicits.current

  // implicit  val current = "."

  def files(implicit directory: String): Either[String, List[File]] =
    try {
      val file = new File(directory)
      if(file.isDirectory)
        Right(file.listFiles().toList)
      else
        Right(List.empty[File])
    } catch {
      case e: Throwable => Left(e.getMessage)
    }

  files.map(listOfFiles => listOfFiles foreach println)
}

object Implicits {
  implicit val current: String = "."
}

