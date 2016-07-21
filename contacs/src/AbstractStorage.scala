/**
  * Describe abstract storage based on scala->collection->map
  *
  * Created by randy on 06.01.16.
  */

import scala.collection._

class AbstractStorage() {
  // create an empty map
  var storage = mutable.Map[String, User]()

  def getFromHashMap(hash: String): User = {
    for ((keyHash, valueUser) <- storage) {
      if (hash == keyHash) {
        return valueUser
      }
    }
    return null
  }

  def addInHashMap(hash: String, uid: User): String = {
    storage += (hash -> uid)
    return "Report: - New user, "+ uid.userName_ + ": add!\n"
  }

  def delFromHashMap(hash: String): String = {
    val foundUser = getFromHashMap(hash)

    foundUser match {
     case null =>
       return "Report: - User not found, can't remove!\n";

     case _ =>
       storage -= hash;
       return "Report: - User, " + foundUser.userName_ + ": remove!\n";
    }
  }
}
