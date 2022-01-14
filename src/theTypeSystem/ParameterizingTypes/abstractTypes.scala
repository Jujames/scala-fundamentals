package theTypeSystem.ParameterizingTypes

trait  AlgebraicOperationsP[T] {
  def add(a: T, b: T): T
  def sub(a: T, b: T): T
  def mul(a: T, b: T): T
}

object IntegerOpsP extends AlgebraicOperationsP[Int] {
  def add(a: Int, b: Int): Int = a + b
  def sub(a: Int, b: Int): Int = a - b
  def mul(a: Int, b: Int): Int = a * b
}

object abstractTypes extends App {
  import IntegerOpsP._

  println(add(1, 2))
  println(mul(1, 2))

}
