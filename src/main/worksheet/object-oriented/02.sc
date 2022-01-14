/**
 * m3-object-oriented -> 02.sc
 */
class Employee {
  var first: String = ""
  var last: String = ""
}

val bobMartin = new Employee
bobMartin.first = "Bob"
bobMartin.last = "Martin"

val taylorJackson = new Employee
taylorJackson.first = "Taylor"
taylorJackson.last = "Jackson"

bobMartin == taylorJackson




