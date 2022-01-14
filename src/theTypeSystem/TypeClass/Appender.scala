package theTypeSystem.TypeClass

object Appender extends App {

  //def append(a: List[Int], b: List[Int]): List[Int] = a ++ b

   // this is param polymorphism
  def append[T](a: List[T], b: List[T]): List[T] = a ++ b

  val listFirst = List(1, 2, 3)
  val listSecond = List(4, 5)

  println(s"Calling append for Integer List: ${append(listFirst, listSecond)}")



}
