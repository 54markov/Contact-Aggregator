/**
  * Created by randy on 14.05.17.
  */
class User(userName: String) {
  /*
   *user name field
   */
  private val userName_ = userName
  /*
   * user identefication field
   */
  private val uid_      = new UID
  /*
   * user services filed
   */
  private val userService_ = scala.collection.mutable.Map[String, Service]()

  /*
   * Getters
   */
  def getName : String = {
    userName_
  }

  def getInfo : String = {
    var infoString = userName_ + "\n"

    userService_ foreach {
      case (key, value) => infoString += value.description_; infoString += "\n"
    }

    infoString
  }

  def addService(sid: Service) {
    userService_ += (sid.sid_.getHash(sid.name_) -> sid)
  }

  def delService(sid: Service) {
    userService_ -= sid.sid_.getHash(sid.name_)
  }

  def getHash: String = {
    uid_.getHash(userName_)
  }
}
