package theTypeSystem.Basic

object patternMatching extends App {
  sealed trait TaskStatus

  case object Pending extends TaskStatus

  case object InProgress extends TaskStatus

  case object Complete extends TaskStatus

  def returnsTaskStatus: TaskStatus = InProgress

  returnsTaskStatus match {
    case Pending => println("Task is Pending")
    case InProgress => println("Task is InProgress")
    case Complete => println("Task is completed")
  }
}
