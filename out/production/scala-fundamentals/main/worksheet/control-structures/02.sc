class Priority(val value: String) {
  override def toString: String = value
}
class Status(val value: String) {
  override def toString: String = value
}

class Task(val value: String,
           val priority: Priority,
           val status: Status) {
  override def toString: String =
    s"[P: $priority][S:$status] - $value"
}

// priorities
val high = new Priority("high")
val medium = new Priority("medium")
val low = new Priority("low")

// statuses
val todo = new Status("todo")
val inProgress = new Status("inProgress")
val done = new Status("done")

//Task
val t1 = new Task("Finished Scala Module", high, inProgress)
val t2 = new Task("Book flight tickets", high, todo)
val t3 = new Task("Order wine for Friday", medium, todo)
val t4 = new Task("Test Awesome Feature", medium, inProgress)
val t5 = new Task("Reply to Marc", low, todo)
val t6 = new Task("Get s** done", high, done)
val t7 = new Task("Book Accommodation for talk", medium, done)

val tasks: Seq[Task] = Seq(t1, t2, t3, t4, t5, t6, t7)

def getTasMatching(matcher: Task => Boolean) = {
  for (task <- tasks; if matcher(task))
    yield task
}

def highPriorityTasks = (task: Task) => task.priority == high
def lowPriorityTasks = (task: Task) => task.priority == low
def taskInProgress = (task: Task) => task.status == inProgress
def taskTodo = (task: Task) => task.status == todo

getTasMatching(highPriorityTasks) foreach println
println("------------------------------")
getTasMatching(lowPriorityTasks) foreach println
println("------------------------------")
getTasMatching(taskInProgress) foreach println


