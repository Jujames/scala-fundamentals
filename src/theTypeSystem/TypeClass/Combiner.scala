package theTypeSystem.TypeClass

trait Combiner {

  // This is known as AdHoc Polymorphism.
  def combine(a: Int, b: Int): Int = a + b

  def combine(a: Int, b: Int, c: Int): Int = a + b + c

  def combine(a: String, b: String): String = s"$a$b"

  def combine[T](a: List[T], b: List[T]): List[T] = a ++ b
}

object Combiner extends Combiner

object Demo extends App {
  import Combiner._

  println(s"Calling combine for Integer: ${combine(21, 22)}")
  println(s"Calling combine for String: ${combine("foo", "bar")}")

  val listFirst = List(1, 2, 3)
  val listSecond = List(4, 5)

  println(s"Calling add for Integer List: ${combine(listFirst, listSecond)}")
}


