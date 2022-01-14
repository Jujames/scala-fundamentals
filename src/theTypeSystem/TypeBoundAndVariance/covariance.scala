package theTypeSystem.TypeBoundAndVariance

abstract class Employee

case class Developer(name: String) extends Employee
case class SaleAssociate(name: String) extends  Employee

object covarianceAndContravariance extends App {

  // Collection of all the employees
  val employees = new scala.collection.mutable.ArrayBuffer[Employee]()
  val developers: List[Developer] = List(Developer("Allen"), Developer("Bob"))
  val saleAssociate: List[SaleAssociate] = List(SaleAssociate("Chris"), SaleAssociate("David"))

  def addEmployees(es: List[Employee]): Unit = employees.appendAll(es)

  addEmployees(developers)
  addEmployees(saleAssociate)

  employees foreach println

}
