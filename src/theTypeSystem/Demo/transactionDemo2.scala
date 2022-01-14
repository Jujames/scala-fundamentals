package theTypeSystem.Demo



import java.time.LocalDateTime
import java.util.UUID


sealed abstract class TransactionTypes

trait OnLine extends  TransactionTypes
trait Offline extends  TransactionTypes

case object creditCard extends OnLine
case object myWallet extends OnLine
case object myNetBanking extends OnLine

case object myCash extends Offline
case object myCheque extends Offline

case class Amounts(value: Double, currency: String)

case class Transactions[+T <: TransactionTypes](id: UUID,
                           amount: Amounts,
                           txnTime: LocalDateTime,
                           txnType: T)

object myTransactionUtils {
       /* Upper type bound */
  def compensate[A <: OnLine](transaction: Transactions[A]): Boolean = {
    println(s"Transaction is being compensated")

    true
  }
}

object transactionDemo2 extends App {

  import myTransactionUtils._

  val transaction = Transactions(UUID.randomUUID(), Amounts(4, "USD"), LocalDateTime.now(), creditCard)
  val offlineTxn = Transactions(UUID.randomUUID(), Amounts(4, "USD"), LocalDateTime.now(), myCash)

  println(s"${transaction.txnType} Transaction: $transaction")
  println(s"${offlineTxn.txnType} Transaction: $offlineTxn")

  val compensatoryTxn = compensate(transaction)

  println(compensatoryTxn)
}
