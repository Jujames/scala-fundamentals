package theTypeSystem.TypeBoundAndVariance

abstract class Passenger

class BusinessPassenger extends Passenger
class EconomyPassenger extends  Passenger

class CorporatePassenger extends BusinessPassenger

class AirplaneSeat[-T]

object contravariance extends App {

  def reserveForCorporate(airplaneSeat: AirplaneSeat[CorporatePassenger]): Unit =
    println(s"Reserving seat.")

  reserveForCorporate(new AirplaneSeat[CorporatePassenger])
  reserveForCorporate(new AirplaneSeat[BusinessPassenger])

}
