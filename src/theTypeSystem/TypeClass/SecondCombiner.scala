package theTypeSystem.TypeClass

trait Combiner1[T] {
  def combine(a: T, b: T): T
}

object Combiner1 {

  implicit val intCombiner: Combiner1[Int] = new Combiner1[Int] {
    override def combine(a: Int, b: Int): Int = a + b
  }

  implicit val stringCombiner: Combiner1[String] = new Combiner1[String] {
    override def combine(a: String, b: String): String = s"$a$b"
  }

  implicit def listCombiner[T]: Combiner1[List[T]] = new Combiner1[List[T]] {
    override def combine(a: List[T], b: List[T]): List[T] = a ++ b
  }
}

object CombinerOps {
  def combine[T](a: T, b: T)(implicit ev: Combiner1[T]): T = ev.combine(a, b)

  implicit class CombinerExt[T](pair: Tuple2[T, T]) {
    def combine(implicit ev: Combiner1[T]): T = ev.combine(pair._1, pair._2)
  }
}

object SecondCombiner extends App {
  import CombinerOps._

  val combineIntegers = combine(2, 4)
  println(s"Combined Integer values are: $combineIntegers")
  println(combine("Well", "Done"))
  println(combine(List(1,2), List(3, 4, 5)))

  val combined = (2, 5).combine
  println(s"Combined Integer values: $combined")
}
