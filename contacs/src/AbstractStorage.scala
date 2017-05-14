/**
  * Created by randy on 14.05.17.
  */
import scala.collection._

class AbstractStorage() {
  // create an empty map
  private val storage = mutable.Map[String, User]()

  def getFromHashMap(hash: String): Option[User] = {
    storage.get(hash)
  }

  def addInHashMap(hash: String, uid: User): String = {
    storage += (hash -> uid)

    "Report: - New user, "+ uid.getName + ": add!\n"
  }

  def delFromHashMap(hash: String): String = {
    getFromHashMap(hash) match {
      case Some(foundUser) =>
        storage -= hash
        "Report: - User, " + foundUser.getName + ": remove!\n"
      case None =>
        "Report: - User not found, can't remove!\n"
    }
  }
}