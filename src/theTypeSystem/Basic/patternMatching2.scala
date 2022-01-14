package theTypeSystem.Basic

object patternMatching2 extends App {
  sealed trait TaskStatus

  case object Pending extends TaskStatus

  case object InProgress extends TaskStatus

  case object Complete extends TaskStatus

  case class Task(name: String, status: TaskStatus, isPriority: Boolean)

  def manageTask(task: Task): Unit = {

    val taskStatus = task.status

    taskStatus match {
      case Pending if task.isPriority => println(s"assigning Task: ${task.name}")
      case Pending => println("Task is Pending")
      case InProgress => println("Task is InProgress.")
      case Complete => println("Task is completed")
    }
  }

  // to label every Task:
  def labelPriorityTask(task: Task, labelString: String): Task = {
    task match {
      case Task(name, status, true) => Task(s"[$labelString] - $name", status, isPriority = true)
      case task: Task => task
    }
  }

  val task = Task("Decide the title", Pending, isPriority = true)

  manageTask(task)
  println(labelPriorityTask(task, "Important").name)
}
