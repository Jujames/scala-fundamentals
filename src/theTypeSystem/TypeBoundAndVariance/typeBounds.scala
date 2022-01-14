package theTypeSystem.TypeBoundAndVariance

object typeBounds extends App {

  abstract  class  Passenger
  class BusinessPassenger extends Passenger
  class CorporatePassenger extends BusinessPassenger
  class EconomyPassenger extends  Passenger

  // Upper Bound And Lower Bound
  class AirplaneSeat[-T >: CorporatePassenger <: Passenger]

  val corporatePassengerSeat = new AirplaneSeat[CorporatePassenger]()
  val businessPassengerSeat = new AirplaneSeat[BusinessPassenger]()
  val passengerSeat = new AirplaneSeat[Passenger]()

  /* does not conform with lower type bound
   val economyPassengerSeat = new AirplaneSeat[EconomyPassenger]()
  */
  // will not compile because it does not conform to AirplaneSeats type parameter bounds.
  /** val stringSeat = new AirplaneSeat[String]()  **/

}
