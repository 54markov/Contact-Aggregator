/**
  * Created by Markov V.A on 14.05.17.
  */
class UserManager(abstractStorage: AbstractStorage) extends Logger {
  /*
   * Work With Users
   */
  def addUser(user: User): ResultOperation.Value = {
    abstractStorage.addInHashMap(user.getHash, user)
  }

  def delUser(user: User): ResultOperation.Value = {
    abstractStorage.delFromHashMap(user.getHash)
  }

  def getUser(user: User): Option[User] = {
    abstractStorage.getFromHashMap(user.getHash)
  }

  /*
   * Work With Services
   */
  def addService(user: User, sid: Service) : ResultOperation.Value = {
    abstractStorage.getFromHashMap(user.getHash) match {
      case Some(foundUser) =>
        foundUser.addService(sid)
        logToFile("[INFO]: Add service, " + foundUser.getName + " complete!\n")
        ResultOperation.OperationComplete
      case None =>
        logToFile("[INFO]: Can't add service, user not found\n")
        ResultOperation.OperationFail
    }
  }

  def delService(user: User, sid: Service) : ResultOperation.Value = {
    abstractStorage.getFromHashMap(user.getHash) match {
      case Some(foundUser) =>
        foundUser.addService(sid)
        logToFile("[INFO]: remove service, " + foundUser.getName + " complete!\n")
        ResultOperation.OperationComplete
      case None =>
        logToFile("[INFO]: can't remove service, user not found")
        ResultOperation.OperationFail
    }
  }
}