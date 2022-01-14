package theTypeSystem.TypeClass

object polymorphism extends App {
  // This is example of Method overloading of same method with diff types.
  def add(a: Int, b: Int): Int = a + b

  def add(a: Double, b: Double): Double = a + b

  println(s"Calling add for Integer: ${add(1, 22)}")
  println(s"Calling add for Double: ${add(22.5, 1.5)}")

}
