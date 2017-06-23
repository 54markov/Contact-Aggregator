/**
  * Created by Markov V.A on 14.05.17.
  */
import scala.collection._

class AbstractStorage extends Logger {
  // create an empty map
  private val storage = mutable.Map[String, User]()

  def getFromHashMap(hash: String): Option[User] = {
    storage.get(hash)
  }

  def addInHashMap(hash: String, uid: User): ResultOperation.Value = {
    storage += (hash -> uid)
    logToFile("[INFO]: - New user, "+ uid.getName + ": add!\n")
    ResultOperation.OperationComplete
  }

  def delFromHashMap(hash: String): ResultOperation.Value = {
    getFromHashMap(hash) match {
      case Some(foundUser) =>
        storage -= hash
        logToFile("[INFO]: - User, " + foundUser.getName + ": remove!\n")
        ResultOperation.OperationComplete
      case None =>
        logToFile("[INFO]: - User not found, can't remove!\n")
        ResultOperation.OperationFail
    }
  }
}
