/**
  * Created by Markov V.A on 14.05.17.
  */
class User(name: String) {
  /*
   *User name
   */
  private val userName : String = name
  /*
   * User ID
   */
  private val userID = new UID

  /*
   * User service
   */
  private val userService = scala.collection.mutable.Map[String, Service]()

  /*
   * Getters
   */
  def getName : String = { userName }
  def getHash : String = { userID.getHash(userName) }

  def getInfo : String = {
    var infoString = userName + "\n"

    userService foreach {
      case (key, value) => infoString += value.getDescription; infoString += "\n"
    }

    infoString
  }

  /*
   * Util
   */
  def addService(service: Service) { userService += (service.encryptService -> service) }
  def delService(service: Service) { userService -= service.encryptService }
}