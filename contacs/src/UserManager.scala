/**
  *
  * Describe actual user management work
  *
  * Created by randy on 04.01.16.
  */

class UserManager(storage: AbstractStorage) {
  var abstractStorage = storage

  // work with users:
  // add user
  def addUser(uid: User): Unit = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val result: String = abstractStorage.addInHashMap(userHash, uid)
    println(result)
  }

  // delete user
  def delUser(uid: User) {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val result: String = abstractStorage.delFromHashMap(userHash)
    println(result)
  }


  // search user
  def getUser(uid: User): User = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    if (foundUser == null) {
      return null
    } else {
      return foundUser
    }
  }

  // work with serives:
  // add service to user
  def addService(uid: User, sid: Service): String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    if (foundUser == null) {
      return "can't add service, user not found\n"
    } else {
      foundUser.addService(sid)
      return "add service, " + foundUser.userName_ + " complete!\n"
    }
  }

  // delete service from user
  def delService(uid: User, sid: Service): String = {
    // my implementation will be here
    val userHash = uid.uid_.getHash(uid.userName_)
    val foundUser = abstractStorage.getFromHashMap(userHash)

    if (foundUser == null) {
      return "can't remove service, user not found"
    } else {
      foundUser.addService(sid)
      return "remove service, " + foundUser.userName_ + " complete!\n"
    }
  }
}
