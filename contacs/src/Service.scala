/**
  * Created by Markov V.A on 14.05.17.
  */
class Service(serviceName: String, serviceDescription: String) {
  /*
   * Service name
   */
  val name : String = serviceName

  /*
   * Service description
   */
  val description : String = serviceName + ":" + serviceDescription

  /*
   * Service identefication
   */
  val sid = new SID

  /*
   * Getters
   */
  def getName : String = { name }
  def getDescription : String = { description }
  def getSID: SID = { sid }

  def encryptService : String =  { sid.getHash(name) }
}