package theTypeSystem.Demo

import java.time.LocalDateTime
import java.util.UUID


sealed trait Plans
case object Monthlys extends Plans
case object BiAnnuals extends Plans
case object Annuals extends Plans

sealed trait Subscribable

case class Channels(name: String) extends Subscribable
case class TVPackages(name: String, channel: Set[Channels]) extends Subscribable

case class SubscriptionPeriods(startDate: LocalDateTime, endDate: LocalDateTime)
case class Subscriptions(
                         name: String,
                         defaultTVPackages: Map[TVPackages, Plans],
                         additionalTVPackages: Map[TVPackages, Plans],
                         additionalChannels: Map[Channels, Plans],
                         subscriptionPeriod: SubscriptionPeriods
                       ) extends  Subscribable

case class Subscribed(name: String)
case class User(name: String, accountId: UUID)

trait Subscriber[T] {
  def subscribe(subscribable: T, user: User): Subscribed
}

object Subscriber {

  implicit val channelSubscriber: Subscriber[Channels] = new Subscriber[Channels] {
    override def subscribe(subscribable: Channels, user: User): Subscribed = {
      Subscribed(s"CH${subscribable.name}") // Perform some process on Channel
    }
  }

  implicit val tvPackageSubscriber: Subscriber[TVPackages] = new Subscriber[TVPackages] {
    override def subscribe(subscribable: TVPackages, user: User): Subscribed = {
      Subscribed(s"TVP${subscribable.name}") // Perform some process on TVPackage
    }
  }

  implicit val subscriptionSubscriber: Subscriber[Subscriptions] = new Subscriber[Subscriptions] {
    override def subscribe(subscribable: Subscriptions, user: User): Subscribed = {
      Subscribed(s"SUB${subscribable.name}") // Perform some process on Subscriptions
    }
  }
}

object SubscriberOps {
  def subscribe[T](subscribable:  T, user: User)(implicit ev: Subscriber[T]): Subscribed =
    ev.subscribe(subscribable, user)
}

object Dth2Demo extends App {

  import SubscriberOps._

  val user = User("Alice", UUID.randomUUID())
  val channelOne = Channels("One")
  val tvPackageSports = TVPackages("SportPack", Set(Channels("SportOne"), channelOne))
  val userSubscribed = subscribe(tvPackageSports, user)

  println(s"Subscribed name: ${userSubscribed.name}")
}
