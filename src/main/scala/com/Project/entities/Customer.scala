package main.scala.com.Project.entities

import java.time.LocalDate
import java.util.UUID

class Customer(first: String, last: String, email: Email, dob: LocalDate) {
  val id: UUID = UUID.randomUUID()

  override def toString: String = s"$id -> $first, $last, $email"

}
