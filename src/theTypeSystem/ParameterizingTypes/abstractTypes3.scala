package theTypeSystem.ParameterizingTypes

trait OperationGenerator[In] {
  type Out

  def operation: Out
}

object abstractTypes3 extends  App {
  // Type Alias
  type OperationInputType = String

  val capitalizer = new OperationGenerator[OperationInputType] {
    override type Out = OperationInputType => String

    override def operation: Out =
      (str: OperationInputType) => str.capitalize
  }

  val listOfString = List("first", "second", "third", "fourth")

  listOfString.map(capitalizer.operation) foreach println

}
