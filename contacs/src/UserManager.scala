/**
  * Created by randy on 14.05.17.
  */
class UserManager(abstractStorage: AbstractStorage) {
  /*
   * Work With Users
   */

  // add user
  def addUser(user: User): String = {
    abstractStorage.addInHashMap(user.getHash, user)
  }

  // delete user
  def delUser(user: User) : String = {
    abstractStorage.delFromHashMap(user.getHash)
  }

  // search user
  def getUser(user: User): Option[User] = {
    abstractStorage.getFromHashMap(user.getHash)
  }

  /*
   * Work With Services
   */

  // add service to user
  def addService(user: User, sid: Service): String = {
    abstractStorage.getFromHashMap(user.getHash) match {
      case Some(foundUser) =>
        foundUser.addService(sid)
        "add service, " + foundUser.getName + " complete!\n"
      case None =>
        "can't add service, user not found\n"
    }
  }

  // delete service from user
  def delService(user: User, sid: Service): String = {
    abstractStorage.getFromHashMap(user.getHash) match {
      case Some(foundUser) =>
        foundUser.addService(sid)
        "remove service, " + foundUser.getName + " complete!\n"
      case None =>
        "can't remove service, user not found"
    }
  }
}