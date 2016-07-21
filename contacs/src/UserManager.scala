/*
 * Describe actual user management work
 *
 * Created by randy on 04.01.16.
 */

class UserManager(storage: AbstractStorage) {
  var abstractStorage = storage

  // work with users:
  // add user
  def addUser(uid: User): String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    return abstractStorage.addInHashMap(userHash, uid)
  }

  // delete user
  def delUser(uid: User) : String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    return abstractStorage.delFromHashMap(userHash)
  }


  // search user
  def getUser(uid: User): User = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    foundUser match {
      case null => return null
      case _ => return foundUser
    }
  }

  // work with serives:
  // add service to user
  def addService(uid: User, sid: Service): String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    foundUser match {
      case null =>
        return "can't add service, user not found\n"

      case _ =>
        foundUser.addService(sid)
        return "add service, " + foundUser.userName_ + " complete!\n"
    }
  }

  // delete service from user
  def delService(uid: User, sid: Service): String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    foundUser match {
      case null =>
        return "can't remove service, user not found"

      case _ =>
        foundUser.addService(sid)
        return "remove service, " + foundUser.userName_ + " complete!\n"
    }
  }
}
