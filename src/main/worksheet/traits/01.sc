import java.util.UUID

trait Db {
  private var contents: Map[String, String] = Map.empty

  protected def save(key: String, value: String): Unit =
    contents += (key -> value)

  def get(key: String): Option[String] = contents.get(key)
}

class Bank extends Db {
  def openAccount(userId: String): String = {
    val accountId = "A-" + UUID.randomUUID()
    save(userId, accountId)
    accountId
  }

  def getAccount(userId: String): Option[String] = get(userId)
}

val bank = new Bank
val bobUserId ="U-BOB-" + UUID.randomUUID()
val amyUserid = "U-AMY-" + UUID.randomUUID()

val bobAccountId = bank.getAccount(bobUserId)
val amyAccountId = bank.openAccount(amyUserid)

assert(bobAccountId == bank.getAccount(bobUserId).get,
 "Bob Account Id do not match")
assert(amyAccountId == bank.getAccount(amyUserid).get,
  "Amy Account Id do not match")






